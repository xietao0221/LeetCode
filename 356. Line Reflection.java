// if x1 and x2 are reflected based on x0, then (x1 + x2) / 2 = x0 => x1 + x2 = 2 * x0
// for every pair (x1, x2), if they are reflected, the (x1 + x2) is constant which is (xmin + xmax)
public class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for(int[] point: points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            set.add(point[0] + "/" + point[1]);
        }
        sum = min + max;
        
        for(int[] point: points) {
            if(!set.contains((sum - point[0]) + "/" + point[1])) return false;
        }
        return true;
    }
}