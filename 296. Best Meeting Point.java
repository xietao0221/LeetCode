// https://discuss.leetcode.com/topic/27762/java-2ms-python-40ms-two-pointers-solution-no-median-no-sort-with-explanation
public class Solution {
    public int minTotalDistance(int[][] grid) {
        int[] rowSum = new int[grid[0].length], colSum = new int[grid.length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                rowSum[j] += grid[i][j];
                colSum[i] += grid[i][j];
            }  
        }
        return minDistance1D(rowSum) + minDistance1D(colSum);
    }
    
    public int minDistance1D(int[] array) {
        int i = -1, j = array.length;
        int left = 0, right = 0, res = 0;
        while(i != j) {
            if(left < right) {
                res += left;
                left += array[++i];
            } else {
                res += right;
                right += array[--j];
            }
        }
        return res;
    }
}