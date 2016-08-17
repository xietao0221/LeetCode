/*
live & live neighbor < 2: die
live & live neighbor 2 or 3: live
live & live neighbor > 3: die
dead & live neighbor 3: live
*/
public class Solution {
    // dead -> dead: 0; 
    // live -> live: 1;
    // dead -> live: 2;
    // live -> dead: 3;
    public void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int live = countNeighbors(board, i, j);
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 3;
                if(board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 2) {
                    board[i][j] = 1;
                } else if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countNeighbors(int[][] board, int row, int col) {
        int count = 0, rowN = board.length, colN = board[0].length;
        if(row>0 && (board[row-1][col] == 1 || board[row-1][col] == 3)) count++;
        if(row<rowN-1 && (board[row+1][col] == 1 || board[row+1][col] == 3)) count++;
        if(col>0 && (board[row][col-1] == 1 || board[row][col-1] == 3)) count++;
        if(col<colN-1 && (board[row][col+1] == 1 || board[row][col+1] == 3)) count++;
        if(row>0 && col>0 && (board[row-1][col-1] == 1 || board[row-1][col-1] == 3)) count++;
        if(row<rowN-1 && col<colN-1 && (board[row+1][col+1] == 1 || board[row+1][col+1] == 3)) count++;
        if(row>0 && col<colN-1 && (board[row-1][col+1] == 1 || board[row-1][col+1] == 3)) count++;
        if(row<rowN-1 && col>0 && (board[row+1][col-1] == 1 || board[row+1][col-1] == 3)) count++;
        return count;
    }
}