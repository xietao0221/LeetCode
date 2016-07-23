public class Solution {
    // use TreeMap's lastKey to get the highest value in the sliding window
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            queue.put(nums[i], queue.containsKey(nums[i]) ? queue.get(nums[i])+1 : 1);
            if(count >= k) {
                if(queue.get(nums[i-k]) == 1) queue.remove(nums[i-k]);
                else queue.put(nums[i-k], queue.get(nums[i-k])-1);
            }
            // lastKey is the highest key currently in the Tree Map
            res[count-k >= 0 ? count - k + 1 : 0] = queue.lastKey();
            count++;
        }
        return res;
    }
    */
    
    // use Deque to save all valid indexes whose value is greater than the current one
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            // ensure the size of sliding window
            // peek() is the oldest one
            if(!queue.isEmpty() && queue.peek() < i - k + 1) queue.poll();
            
            // must use while, ensure all values in the sliding is greater than the current one
            // peekLast() and pollLast() is newest one
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            
            // offer to the tail, the value in the queue is decreasing
            queue.offer(i);
            
            // peek() is the oldest one and the largest one
            if(i - k + 1 >= 0) res[i-k+1] = nums[queue.peek()];
        }
        return res;
    }
}