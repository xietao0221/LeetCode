// similar to '48. Rotate Image'
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0) return result;
        int i = 1;
        for(int row = 0; row < n / 2; row++) {
            int colSize = n - row - 1, gap = colSize - row;
            for(int col = row; col < colSize; col++) {
                result[row][col] = i;
                result[col][n - 1 - row] = i + gap;
                result[n - 1 - row][n - 1 - col] = i + 2 * gap;
                result[n - 1 - col][row] = i + 3 * gap;
                i++;
            }
            i += 3 * gap;
        }
        if(n % 2 != 0) result[n / 2][n / 2] = n * n;
        return result;
    }
}