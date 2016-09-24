// the area sum of all smaller rectangles is the same as the area of bounder rectangle
// all points except for four bounder should be even
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        
        Set<String> set = new HashSet<>();
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MIN_VALUE, down = Integer.MAX_VALUE;
        int areaSum = 0;
        
        for(int[] rectangle: rectangles) {
            // check the bounder of all rectangles
            left = Math.min(left, rectangle[0]);
            down = Math.min(down, rectangle[1]);
            right = Math.max(right, rectangle[2]);
            top = Math.max(top, rectangle[3]);
            
            // save 4 points into set
            String p1 = rectangle[0] + "/" + rectangle[1], p2 = rectangle[2] + "/" + rectangle[1],
                p3 = rectangle[0] + "/" + rectangle[3], p4 = rectangle[2] + "/" + rectangle[3];
            if(set.contains(p1)) set.remove(p1);
            else set.add(p1);
            
            if(set.contains(p2)) set.remove(p2);
            else set.add(p2);
            
            if(set.contains(p3)) set.remove(p3);
            else set.add(p3);
            
            if(set.contains(p4)) set.remove(p4);
            else set.add(p4);
            
            // calculate the curr area
            areaSum += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }
        
        if(!set.contains(left + "/" + down) || !set.contains(right + "/" + down) || 
            !set.contains(left + "/" + top) || !set.contains(right + "/" + top) || set.size() != 4) return false;
        return areaSum == (right - left) * (top - down);
    }
}