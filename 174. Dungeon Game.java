// the health at any cell should be at least 1
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];

        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[0].length - 1; j >= 0; j--) {
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    // deal with the right-bottom cell
                    dp[i][j] = 1 - dungeon[i][j] < 1 ? 1 : 1 - dungeon[i][j];
                } else {
                    // special case: the right most col or bottom row
                    int right = j + 1 == dp[0].length ? Integer.MAX_VALUE :
                            (dp[i][j + 1] - dungeon[i][j] < 1 ? 1 : dp[i][j + 1] - dungeon[i][j]);
                    int bottom = i + 1 == dp.length ? Integer.MAX_VALUE :
                            dp[i + 1][j] - dungeon[i][j] < 1 ? 1 : dp[i + 1][j] - dungeon[i][j];
                    dp[i][j] = Math.min(right, bottom);
                }
            }
        }
        return dp[0][0];
    }
}