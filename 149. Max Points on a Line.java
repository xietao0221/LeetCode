/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

// use string as the key
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;

        int res = 1;                                // there is one point at least
        Map<String, Integer> map = new HashMap<>();
        
        // for each point, check other point
        for(int i = 0; i < points.length - 1; i++) {
            int dup = 0;
            map.clear();
            
            // no need to check the point before i: if those points are on the same line, those must be calculated before
            for(int j = i + 1; j < points.length; j++) {
                if(points[j].y == points[i].y && points[j].x == points[i].x) {
                    dup++;
                    continue;
                }
                
                // k = (y2 - y1) / (x2 - x1) = y / x
                // if x and y are divided by their GCD, the pair (x', y') is the unique if k is unique
                int y = points[j].y - points[i].y, x = points[j].x - points[i].x, gcd = generateGCD(x, y);
                y /= gcd;
                x /= gcd;
                String tmpKey = x + "," + y;        // after GCD, same slope has same (x, y) pair
                map.put(tmpKey, map.containsKey(tmpKey) ? map.get(tmpKey) + 1 : 2);
            }
            
            res = Math.max(res, dup + 1);           // the local min is (1 + dup)
            for(int value : map.values()) {
                res = Math.max(res, value + dup);
            }
        }
        return res;
    }
    
    private int generateGCD(int a, int b) {
        if(b == 0) return a;
        return generateGCD(b, a % b);
    }
}


// use (double)slope as the key
/*
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int res = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = 0; i < points.length - 1; i++) {
            int tmpRes = 1, dup = 0;
            map.clear();
            
            for(int j = i + 1; j < points.length; j++) {
                // check whether they are the same point
                if(points[j].y == points[i].y && points[j].x == points[i].x) {
                    dup++;
                    continue;
                }
                
                // 0.0 and -0.0 are two different keys
                double slope = points[j].x == points[i].x ? 
                    (double)Integer.MAX_VALUE : 
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 2);
            }
            
            res = Math.max(res, tmpRes + dup);
            for(Integer value : map.values()) {
                res = Math.max(res, value + dup);
            }
        }
        return res;
    }
}
*/