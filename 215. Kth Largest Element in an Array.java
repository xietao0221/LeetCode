public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // the default heap is min-heap, the top of heap is min, queue.peek(), queue.poll() is the min
        // this heap always keep the k largest number, and queue.peek() is the smallest in these k numbers
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