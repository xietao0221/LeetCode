// https://discuss.leetcode.com/topic/48875/accepted-c-codes-with-explanation-and-references/4
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for(int left=0; left<matrix[0].length; left++) {
            int[] sumCol = new int[matrix.length];
            for(int right=left; right<matrix[0].length; right++) {
                // similar to kadane algorithm
                for(int row=0; row<matrix.length; row++) sumCol[row] += matrix[row][right];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);     // in case there is just one row
                int currSum = 0;
                for(int sum: sumCol) {
                    currSum += sum;
                    // ceiling is the least number which is greater than or equals to (currSum-k)
                    // so (currSum-ceiling) must be the largest number which is less than or equals to k 
                    Integer ceiling = set.ceiling(currSum - k);
                    if(ceiling != null) res = Math.max(res, currSum - ceiling);
                    // must add to set at the end
                    set.add(currSum);
                }
            }
        }
        return res;
    }
}