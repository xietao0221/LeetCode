// https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
// similar to '373. Find K Pairs with Smallest Sums', this problem has col arrays, but that problem has 2 arrays
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        
        // input the first row
        for(int j = 0; j < matrix[0].length; j++) queue.offer(new Tuple(0, j, matrix[0][j]));
        
        // iterate (k-1) times, because we need to call queue.poll() at the end
        while(--k > 0) {
            Tuple curr = queue.poll();
            if(curr.row < matrix.length - 1) {
                queue.offer(new Tuple(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));    
            }
        }
        return queue.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int row, col, val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int compareTo(Tuple other) {
            return this.val - other.val;
        }
    }
}