/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> map;             // <start, [start, end]>
    
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        
        Integer lower = map.lowerKey(val), higher = map.higherKey(val);     // core
        
        if(lower != null && higher != null && map.get(lower).end + 1 == val && val + 1 == higher) {
            map.get(lower).end = map.get(higher).end;
            map.remove(higher);
        } else if(lower != null && map.get(lower).end + 1 >= val) {
            map.get(lower).end = Math.max(val, map.get(lower).end);
        } else if(higher != null && val + 1 == higher) {
            map.put(val, new Interval(val, map.get(higher).end));
            map.remove(higher);
        } else {
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */