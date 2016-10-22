// https://discuss.leetcode.com/topic/27522/java-python-two-heap-solution-o-log-n-add-o-1-find
// k, k -> k+1, k -> k+1, k+1
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private boolean isEven = true;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(isEven) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        isEven = !isEven;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(isEven) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double)maxHeap.peek();    // part1 has one more element
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();