public class Solution {
    private int[][] dirs = new int[][]{{0, 1},{-1, 0},{1, 0},{-1, 0}};
    
    public int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    dfs(board, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] board, int row, int col) {
        board[row][col] = '.';
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newCol >= 0 && newRow < board.length && 
                newCol < board[0].length && board[newRow][newCol] == 'X') {
                dfs(board, newRow, newCol);        
            }
        }
    }
}