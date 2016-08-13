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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals, new IntervalComparator());
        int start = intervals.get(0).start, end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for(int i=1; i<intervals.size(); i++) {
            int currStart = intervals.get(i).start, currEnd = intervals.get(i).end;
            if(currStart > end) {
                res.add(new Interval(start, end));
                start = currStart;
                end = currEnd;
            } else {
                end = Math.max(currEnd, end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            if(a.start == b.start) return a.end - b.end;
            else return a.start - b.start;
        }
    }
}