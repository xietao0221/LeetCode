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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length < 2) return true;
        
        Arrays.sort(intervals, new IntervalComparator());
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval m, Interval n) {
            if(m.start == n.start) return m.end - n.end;
            return m.start - n.start;
        }
    }
}