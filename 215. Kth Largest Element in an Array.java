// brute force: sort and then find it.
/*
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n: nums) {
            queue.offer(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}