// Time Complexity: O(m+n)
// from right-top, if this element is too large, we can only move left and cannot move up which is previous area; 
// if this element is too small, we can only move down
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while(row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}