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
        List<Interval> res = new ArrayList<>();
        
        int preStart = intervals.get(0).start, preEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            int currStart = intervals.get(i).start, currEnd = intervals.get(i).end;
            
            if(preEnd < currStart) {
                // non-overlap, so add the previous [start, end]
                res.add(new Interval(preStart, preEnd));
                
                // reset the new start and end
                preStart = currStart;
                preEnd = currEnd;
            } else {
                // overlap, anchor the preStart, but reset the preEnd
                preEnd = Math.max(currEnd, preEnd);
            }
        }
        
        // there is one [preStart, preEnd] left, need to be added
        res.add(new Interval(preStart, preEnd));
        
        return res;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start == b.start ? a.end - b.end : a.start - b.start;
        }
    }
}