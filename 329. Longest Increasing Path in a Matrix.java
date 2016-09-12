public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int[][] memo = new int[matrix.length][matrix[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 1;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, memo, dirs, i, j));
            }
        }
        return res;
    }
    
    public int dfs(int[][] matrix, int[][] memo, int[][] dirs, int row, int col) {
        if(memo[row][col] != 0) return memo[row][col];
        int res = 1;
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newCol >= 0 && newRow < matrix.length && newCol < matrix[0].length &&
                    matrix[newRow][newCol] > matrix[row][col]) {
                res = Math.max(res, dfs(matrix, memo, dirs, newRow, newCol) + 1);
            }
        }
        memo[row][col] = res;
        return res;
    }
}