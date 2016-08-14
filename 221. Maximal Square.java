public class Solution {
    // maxLen[i][j] represents the length of square whose right-bottom position is (i-1, j-1).
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int maxSoFar = 0;
        int[][] maxLen = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i=1; i<=matrix.length; i++) {
            for(int j=1; j<=matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1') {
                    maxLen[i][j] = Math.min(Math.min(maxLen[i][j-1], maxLen[i-1][j]), maxLen[i-1][j-1]) + 1;
                    maxSoFar = Math.max(maxLen[i][j], maxSoFar);
                }
            }
        }
        return maxSoFar * maxSoFar;
    }
}