// DFS and Backtracking
public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    
    private boolean solveSudokuHelper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;
                for(char k = '1'; k <= '9'; k++) {
                    // if the assuming value is valid, fill out this cell and search continuously
                    if(isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if(solveSudokuHelper(board)) return true;
                        else board[i][j] = '.';         // backtracking
                    }
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            
            // [3 * (row / 3)][3 * (col / 3)] makes the position to the top-left of each cube
            // i / 3 => 0,0,0,1,1,1,2,2,2
            // i % 3 => 0,1,2,0,1,2,0,1,2
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' && 
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
