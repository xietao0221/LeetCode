// https://discuss.leetcode.com/topic/27522/java-python-two-heap-solution-o-log-n-add-o-1-find
// k, k -> k+1, k -> k+1, k+1
public class MedianFinder {
    private PriorityQueue<Integer> part1 = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> part2 = new PriorityQueue<>();
    private boolean isEven = true;
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(isEven) {
            part2.offer(num);
            part1.offer(part2.poll());      // even to odd, keep the amount of part2 the same as before
        } else {
            part1.offer(num);
            part2.offer(part1.poll());      // odd to even, keep the amount of part1 the same as before
        }
        isEven = !isEven;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(isEven) {
            return (double)(part1.peek() + part2.peek()) / 2.0;
        } else {
            return (double)part1.peek();    // part1 has one more element
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();