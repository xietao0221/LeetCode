public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        if(obstacleGrid[row - 1][col - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[row][col];
        
        // setup the bottom line
        for(int j = col - 1; j >= 0; j--) {
            if(obstacleGrid[row - 1][j] == 0) {
                dp[row - 1][j] = 1;
            } else {
                // if the right point is obstacle and this line is the bottom line
                // the rest of points before this point cannot get the final point
                while(j >= 0) dp[row - 1][j--] = 0;
            }
        }
        
        // setup the right-most line
        for(int i = row - 1; i >= 0; i--) {
            if(obstacleGrid[i][col - 1] == 0) {
                dp[i][col - 1] = 1;
            } else {
                // set all points before this point to 0
                while(i >= 0) dp[i--][col - 1] = 0;
            }
        }
        
        // calculate the rest of grid
        for(int i = row - 2; i >= 0; i--) {
            for(int j = col - 2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}