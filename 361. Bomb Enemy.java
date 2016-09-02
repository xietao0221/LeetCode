// for rows, if there is no Wall, the rowhits can be reused
// for cols, if there is no Wall, the colhits[j] can be reused
// because the the first loop is row, so rowhits use one var, but colhits use an array
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        
        int rowhits = 0, res = 0;
        int[] colhits = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // count the enermy in this row if 'left' is a wall(until reaching another wall)
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for(int k = j; k < grid[0].length && grid[i][k] != 'W'; k++) {
                        rowhits += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                
                // count the enermy on this col if 'up' is a wall(until reaching another wall)
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for(int k = i; k < grid.length && grid[k][j] != 'W'; k++) {
                        colhits[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                
                // if the current cell is empty, calculate the max enermy
                if(grid[i][j] == '0') res = Math.max(res, rowhits + colhits[j]);
            }
        }
        return res;
    }
}