// use Deque to save all valid indexes whose value is greater than the current one
// offer()/pollLast()/peekLast() [---> queue --->] poll()/peek()
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return nums;
        
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();     // save position info
        for(int i = 0; i < nums.length; i++) {
            // ensure the size of sliding window
            // check from the oldest one, use peekFirst/pollFirst
            if(!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.pollFirst();
            
            // must use while, ensure all values in the sliding is greater than the current one
            // the value in queue is always decreasing
            // check from the newest one, use peekLast/pollLast
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            
            // offer to the tail, the value in the queue is decreasing
            queue.offerLast(i);
            
            // peek() is the oldest one and the largest one
            if(i - k + 1 >= 0) res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}

// use TreeMap's lastKey to get the highest value in the sliding window
/*
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            // put into new one
            queue.put(nums[i], queue.containsKey(nums[i]) ? queue.get(nums[i]) + 1 : 1);
            
            // ensure the window size
            if(count >= k) {
                if(queue.get(nums[i - k]) == 1) queue.remove(nums[i - k]);
                else queue.put(nums[i - k], queue.get(nums[i - k]) - 1);
            }
            
            // lastKey is the highest key currently in the Tree Map
            res[count - k >= 0 ? count - k + 1 : 0] = queue.lastKey();
            count++;
        }
        return res;
    }
}
*/