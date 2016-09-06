/* https://www.youtube.com/watch?v=GSBLe8cKu0s
normal condition: sort the buildings based on x
special conditions:
    (1) two starts have same x: the higher one should be picked first. Because if we choose lower one first, this lower height could be the new lastKey() and be marked; but we should mark the higher height, and then the lower one does not hurt the result.
    (2) two ends have same x: the lower one should be picked first. Because if we choose higher one first, the lower one could be the new lastKey() and be marked; but we should remove the lower height and it does not hurt the result, and then remove the higher one, the height reaches 0, that is correct answer.
    (3) one start and one end have same x: the start should be picked first. a) if start's height > end's height, choose start first avoid to paint 0 as the height; b) if start's height < end's height, choose start first avoid to paint 0 and then paint the right answer.
*/
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();

        // put all buildings into the building array
        int index = 0;
        BuildingPoint[] buildingArray = new BuildingPoint[buildings.length * 2];
        for(int[] building: buildings) {
            buildingArray[index] = new BuildingPoint(building[0], building[2], true);
            buildingArray[index + 1] = new BuildingPoint(building[1], building[2], false);
            index += 2;
        }
        Arrays.sort(buildingArray);

        // could use Priority Queue, but the search and remove is O(n), TreeMap is O(logn)
        // <height of building, the occurance this height>
        TreeMap<Integer, Integer> queue = new TreeMap<>();

        // first, the height is 0, and the occurance is 1
        queue.put(0, 1);
        int prevMaxHeight = 0;

        for(BuildingPoint currPoint: buildingArray) {
            if(currPoint.isStart) {     // increase occurance
                if(queue.containsKey(currPoint.y)) queue.put(currPoint.y, queue.get(currPoint.y) + 1);
                else queue.put(currPoint.y, 1);
            } else {                    // decrease occurance
                if(queue.get(currPoint.y) > 1) queue.put(currPoint.y, queue.get(currPoint.y) - 1);
                else queue.remove(currPoint.y);
            }
            
            // get the current highest height
            int currMaxHeight = queue.lastKey();        // get the highest key value
            if(currMaxHeight != prevMaxHeight) {
                res.add(new int[]{currPoint.x, currMaxHeight});
                prevMaxHeight = currMaxHeight;
            }
        }
        return res;
    }

    class BuildingPoint implements Comparable<BuildingPoint>{
        public int x, y;
        public boolean isStart;
        
        public BuildingPoint(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
        
        public int compareTo(BuildingPoint o) {
            if(this.x != o.x) {
                return this.x - o.x;
            } else {
                // if two starts are compared, then higher height building should be picked first: -this.y + o.y
                // if two ends are compared, then lower height building should be picked first: this.y - o.y
                // if one start and end is compared, then start should before the end: -this.y - o.y or this.y + o.y
                return (this.isStart ? -this.y : this.y) - (o.isStart ? -o.y : o.y);
            }
        }
    }
}