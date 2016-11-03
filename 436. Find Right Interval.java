/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
// TreeMap Solution
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) map.put(intervals[i].start, i); 
        
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            Integer ceiling = map.ceilingKey(intervals[i].end);
            res[i] = ceiling == null ? -1 : map.get(ceiling);
        }
        return res;
    }
}