public class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        int[] res = new int[]{0};
        solveNQueens(board, 0, res);
        return res[0];
    }
    
    private void solveNQueens(boolean[][] board, int row, int[] res) {
        if(row == board.length) {
            res[0]++;
            return;
        }
        
        for(int col = 0; col < board.length; col++) {
            if(isValid(board, row, col)) {
                board[row][col] = true;
                solveNQueens(board, row + 1, res);
                board[row][col] = false;
            }
        }
    }
    
    private boolean isValid(boolean[][] board, int row, int col) {
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col]) return false;
        }
        
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j]) return false;
        }
        
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j]) return false;
        }
        return true;
    }
}