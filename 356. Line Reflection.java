public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length < 2) return true;
        Map<Float, Set<Float>> coordinates = new HashMap<>();
        float xMin = Float.MAX_VALUE, xMax = -Float.MAX_VALUE + 1, xMid = 0;
        
        for(int[] point : points) {
            float x = (float)point[0], y = (float)point[1];
            if(!coordinates.containsKey(x)) coordinates.put(x, new HashSet<>());
            coordinates.get(x).add(y);
            xMin = Math.min(xMin, x);
            xMax = Math.max(xMax, x);
        }
        
        xMid = xMin + (xMax - xMin) / 2;
        
        if(coordinates.containsKey(xMid)) coordinates.remove(xMid);
        for(float x: coordinates.keySet()) {
            float target = x >= xMid ? x - 2 * (x - xMid) : x + 2 * (xMid - x);
            for(float y: coordinates.get(x)) {
                if(!coordinates.containsKey(target) || !coordinates.get(target).contains(y)) return false;
            }
        }
        return true;
    }
}