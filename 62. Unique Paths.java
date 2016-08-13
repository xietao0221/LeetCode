// DP Approach: dp(i,j) = dp(i+1,j) + dp(i,j+1), for i<m, j<n
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 || j == n-1) dp[i][j] = 1;
                else dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

// Recursive Approach
/*
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsHelper(0, 0, m-1, n-1, memo);
    }
    
    public int uniquePathsHelper(int row, int col, int rowMax, int colMax, int[][] memo) {
        if(row == rowMax || col == colMax) return 1;
        if(row > rowMax || col > colMax) return 0;
        if(memo[row][col] != 0) return memo[row][col];
        memo[row][col] = uniquePathsHelper(row+1, col, m, n, memo) + uniquePathsHelper(row, col+1, m, n, memo);
        return memo[row][col];
    }
}
*/