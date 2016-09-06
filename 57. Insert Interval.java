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
        
        // after searching, index is the overlap interval
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) index++;
        
        // have to use while loop
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            start = Math.min(intervals.get(index).start, start);
            end = Math.max(intervals.get(index).end, end);
            intervals.remove(index);        // don't need to index++, because the current element is removed
        }
        
        newInterval.start = start;
        newInterval.end = end;
        intervals.add(index, newInterval);
        return intervals;
    }
}