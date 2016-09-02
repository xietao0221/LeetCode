// 2D Kandane Algorithm: https://www.youtube.com/watch?v=yCQN096CwWM
// https://discuss.leetcode.com/topic/48875/accepted-c-codes-with-explanation-and-references/4
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[] tmpCol = new int[matrix.length];
        int res = Integer.MIN_VALUE;
        
        // brute force
        for(int left = 0; left < matrix[0].length; left++) {
            // reset the tmpCol
            Arrays.fill(tmpCol, 0);
            
            for(int right = left; right < matrix[0].length; right++) {
                // Kadane algorithm
                for(int i = 0; i < matrix.length; i++) tmpCol[i] += matrix[i][right];
                
                // if you meet 'no more than' like question, you'd better use TreeSet's floor()/ceiling()
                // like '220. Contains Duplicate III'
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);     // in case there is just one row
                int currSum = 0;
                
                for(int sum: tmpCol) {
                    currSum += sum;
                    // ceiling is the least number which is greater than or equals to (currSum - k)
                    // ceiling >= currSum - k  ==>  currSum - ceiling <= k
                    Integer ceiling = set.ceiling(currSum - k);
                    if(ceiling != null) res = Math.max(res, currSum - ceiling);
                    
                    // must add this currSum to set at the end
                    set.add(currSum);
                }
            }
        }
        return res;
    }
}