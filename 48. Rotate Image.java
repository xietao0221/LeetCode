/*
left-top:       matrix[row][col]
right-top:      matrix[col][n-1-row]
right-bottom:   matrix[n-1-row][n-1-col]
left-bottom:    matrix[n-1-col][row]
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row=0; row<n/2; row++) {
            for(int col=row; col<n-1-row; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n-1-col][row];            // left-top = left-bottom
                matrix[n-1-col][row] = matrix[n-1-row][n-1-col];    // left-bottom = right-bottom
                matrix[n-1-row][n-1-col] = matrix[col][n-1-row];    // right-bottom = right-top
                matrix[col][n-1-row] = tmp;                         // right-top = left-top
            }
        }
    }
}