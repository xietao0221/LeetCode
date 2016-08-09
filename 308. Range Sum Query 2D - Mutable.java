// https://discuss.leetcode.com/topic/30343/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
public class NumMatrix {
    int[][] fenwickTree, originalMatrix;
    int m, n;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        fenwickTree = new int[m+1][n+1];
        originalMatrix = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - originalMatrix[row][col];
        originalMatrix[row][col] = val;
        for (int i=row+1; i<=m; i+=i&(-i)) {
            for (int j=col+1; j<=n; j+=j&(-j)) {
                fenwickTree[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2, col2) - sum(row1-1, col2) - sum(row2, col1-1) + sum(row1-1, col1-1);
    }
    
    private int sum(int row, int col) {
        int sum = 0;
        for (int i=row+1; i>0; i-=i&(-i)) {
            for (int j=col+1; j>0; j-=j&(-j)) {
                sum += fenwickTree[i][j];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);