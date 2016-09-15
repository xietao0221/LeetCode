public class ZigzagIterator {
    // use queue to select element in cycle
    private Queue<Iterator> queue = new LinkedList<>();
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) queue.offer(v1.iterator());
        if(!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator curr = queue.poll();
        int res = (int)curr.next();
        if(curr.hasNext()) queue.offer(curr);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */