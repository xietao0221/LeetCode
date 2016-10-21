class Solution {
    private final int[][] dirs = new int[][]{{-1, -1},{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1}};

    public void reversi(int[][] board, int color) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0 && isValid(board, i, j, color)) board[i][j] = 2 * color;
            }
        }
    }

    private boolean isValid(int[][] board, int row, int col, int color) {
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1], score = 0;
            while(!isOutSide(board, newRow, newCol)) {
                if(board[newRow][newCol] == -color) {
                    score++;
                    newRow += dir[0];
                    newCol += dir[1];
                } else {
                    break;
                }
            }

            if(!isOutSide(board, newRow, newCol) && score > 0 && board[newRow][newCol] == color) return true;
        }
        return false;
    }

    private boolean isOutSide(int[][] board, int row, int col) {
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0) return true;
        return false;
    }
}