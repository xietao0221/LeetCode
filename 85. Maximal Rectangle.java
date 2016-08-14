/*
https://discuss.leetcode.com/topic/6650/share-my-dp-solution
left(i,j) = max(left(i-1,j), cur_left)
right(i,j) = min(right(i-1,j), cur_right)
height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
height(i,j) = 0, if matrix[i][j]=='0'
area = [right(i,j) - left(i,j) + 1] * height(i,j).
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        // use 1d array to do the DP, because DP is only related to its previous row and previous col
        int[] left = new int[matrix[0].length], right = new int[matrix[0].length], height = new int[matrix[0].length];
        int res = 0;
        
        // initialize the dp_right array
        for(int i=0; i<right.length; i++) right[i] = matrix[0].length - 1;
        
        // iterate the whole matrix row by row, and calculate the dp arrays
        for(int i=0; i<matrix.length; i++) {
            int currLeft = 0, currRight = matrix[0].length - 1;
            
            // right array: right->left
            for(int j=matrix[0].length-1; j>=0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = matrix[0].length - 1;    // the right[j] is got by Min, so no boundary is represented using n-1
                    currRight = j - 1;              // the current cell is 0, so set currRight to the next potential position
                }
            }
            
            // left array: left->right; height array: left->right; 
            for(int j=0; j<matrix[0].length; j++) {
                int k = matrix[0].length - 1 - j;
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                    
                    height[j]++;
                } else {
                    left[j] = 0;        // the left[j] is got by Max, so no boundary is represented using 0
                    currLeft = j + 1;   // the current cell is 0, so set the currLeft to the next potential position
                    
                    height[j] = 0;
                }
                res = Math.max(res, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return res;
    }
}