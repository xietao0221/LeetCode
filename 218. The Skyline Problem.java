// https://www.youtube.com/watch?v=GSBLe8cKu0s
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
                // if two starts are compared, then higher height building should be picked first
                // if two ends are compared, then lower height building should be picked first
                // if one start and end is compared, then start should before the end
                return (this.isStart ? -this.y : this.y) - (o.isStart ? -o.y : o.y);
            }
        }
    }
}