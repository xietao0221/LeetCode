public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                int d = distanceSqr(points[i], points[j]);
                map.put(d, map.containsKey(d) ? map.get(d) + 1 : 1);
            }
            
            for(int count: map.values()) res += count * (count - 1);        // combination
            map.clear();
        }
        return res;
    }
    
    private int distanceSqr(int[] a, int[] b) {
        int dx = a[0] - b[0], dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}