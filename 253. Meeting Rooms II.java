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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null) return 0;
        if(intervals.length < 2) return intervals.length;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        PriorityQueue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        minHeap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval target = minHeap.poll();
            if(target.end <= intervals[i].start) {      // no conflict, change one and offer one
                target.end = intervals[i].end;
            } else {                                    // conflict, offer both
                minHeap.offer(intervals[i]);
            }
            minHeap.offer(target);
        }
        return minHeap.size();
    }
}