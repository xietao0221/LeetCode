public class TicTacToe {
    private int[] rows, cols;
    private int diagonal, antiDiagonal, target;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        target = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1, res = sign * target;
        
        rows[row] += sign;
        cols[col] += sign;
        if(row == col) diagonal += sign;
        if(row == target - 1 - col) antiDiagonal += sign;
        if(rows[row] == res || cols[col] == res || diagonal == res || antiDiagonal == res) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */