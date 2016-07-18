public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfsMarking(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        if(row>0 && grid[row-1][col] == '1') dfsMarking(grid, row-1, col);
        if(col>0 && grid[row][col-1] == '1') dfsMarking(grid, row, col-1);
        if(row<grid.length-1 && grid[row+1][col] == '1') dfsMarking(grid, row+1, col);
        if(col<grid[0].length-1 && grid[row][col+1] == '1') dfsMarking(grid, row, col+1);
    }
}