/*
live & live neighbor < 2: die
live & live neighbor 2 or 3: live
live & live neighbor > 3: die
dead & live neighbor 3: live

dead -> dead: 0; 
live -> live: 1;
dead -> live: 2;
live -> dead: 3;
*/
public class Solution {
    private int[][] dirs = new int[][]{{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};
    
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int live = countNeighbors(board, i, j);
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 3;
                if(board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countNeighbors(int[][] board, int row, int col) {
        int count = 0;
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length) continue;
            if((board[newRow][newCol] & 1) != 0) count++;
        }
        return count;
    }
}