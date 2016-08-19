public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new QueueComparator());
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.offer(e);
            if(queue.size() > k) queue.poll();
        }
        
        while(!queue.isEmpty()) res.add(queue.poll().getKey());
        return res;
    }
    
    class QueueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            return e1.getValue() - e2.getValue();
        }
    }
}