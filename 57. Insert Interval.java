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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0, start = newInterval.start, end = newInterval.end;
        
        // skip the interval whose 'end < newInterval.start', which means non-overlap
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) index++;
        
        // for all intervals whose 'end >= newInterval.start && start <= newInterval.end', which means overlap
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            start = Math.min(intervals.get(index).start, start);
            end = Math.max(intervals.get(index).end, end);
            
            // this interval is useless, remove it menas increase index automatically
            intervals.remove(index);
        }
        
        newInterval.start = start;
        newInterval.end = end;
        intervals.add(index, newInterval);
        return intervals;
    }
}