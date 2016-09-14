public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // fill out board with '.'
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // solve it
        solveNQueensHelper(board, res, 0);
        return res;
    }
    
    private void solveNQueensHelper(char[][] board, List<List<String>> res, int row) {
        if(row == board.length) {
            List<String> tmpRes = new LinkedList<>();
            for(int i = 0; i < board.length; i++) {
                tmpRes.add(new String(board[i]));
            }
            res.add(tmpRes);
            return;
        }
        
        // put in one queen for each row, for each queen, we have col choices
        for(int col = 0; col < board[0].length; col++) {
            if(isValid(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, res, row + 1);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        // don't need to check row, because each row we put one queen and then to the next round
        // so we just check col, 135 and 45 degree from this row to row 0, becuase rows below are all '.'
        
        // check column, just iterate to the row-1
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        // check 135 degree
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // check 45 degree
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}