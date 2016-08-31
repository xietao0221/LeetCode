// https://www.youtube.com/watch?v=PwDqpOMwg6U
public class NumMatrix {
    private int[][] sums;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < sums.length; i++) {
            for(int j = 1; j < sums[0].length; j++) {
                // sums[i][j] => matrix[i-1][j-1]
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    // from original matrix to sum matrix, we need to add 1 for each dimensions
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // for the left-top point: need to minus 1
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);