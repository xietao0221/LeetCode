/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));
        int res = 1;
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++) {
            if(end <= intervals[i].start) {
                res++;
                end = intervals[i].end;
            }
        }
        return intervals.length - res;
    }
}