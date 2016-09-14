public class MovingAverage {
    private Queue<Integer> queue;
    private int size, count, sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        count = 0;
        sum = 0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(++count > size) {
            sum -= queue.poll();
            return (double)sum / (double)size;
        } else {
            return (double)sum / (double)count;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */