public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
    
        // deal with the last cell
        dungeon[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 1 ? 1 : 1 - dungeon[m - 1][n - 1];
        
        // deal with the bottom row
        for(int j = n - 2; j >= 0; j--) {
            dungeon[m - 1][j] = dungeon[m - 1][j + 1] - dungeon[m - 1][j] < 1 ? 
                1 : dungeon[m - 1][j + 1] - dungeon[m - 1][j];
        }
        
        // deal with the right-most col
        for(int i = m - 2; i >= 0; i--) {
            dungeon[i][n - 1] = dungeon[i + 1][n - 1] - dungeon[i][n - 1] < 1 ? 
                1 : dungeon[i + 1][n - 1] - dungeon[i][n - 1];
        }
        
        // deal with the rest
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int right = dungeon[i][j + 1] - dungeon[i][j] < 1 ? 1 : dungeon[i][j + 1] - dungeon[i][j];
                int bottom = dungeon[i + 1][j] - dungeon[i][j] < 1 ? 1 : dungeon[i + 1][j] - dungeon[i][j];
                dungeon[i][j] = Math.min(right, bottom);
            }
        }
        return dungeon[0][0];
    }
}