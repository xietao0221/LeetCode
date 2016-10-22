class Solution {
    private final int[][] dirs = new int[][]{{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1},{1,0},{1,0}};

    public boolean reversiDead(int[][] board, int row, int col) {
        int self = board[row][col];
        for(int i = 0; i < dirs.length / 2; i++) {
            if(isDead(board, row, col, dirs[i], self) &&
                    isDead(board, row, col, dirs[dirs.length - 1 - i], self)) return true;
        }
        return false;
    }

    private boolean isDead(int[][] board, int row, int col, int[] dir, int self) {
        int newRow = row + dir[0], newCol = col + dir[1];
        while(!isOutSide(board, newRow, newCol)) {
            if(board[newRow][newCol] == self) {
                newRow += dir[0];
                newCol += dir[1];
            } else if(board[newRow][newCol] == -self) {
                break;
            } else {
                return false;
            }
        }
        return !isOutSide(board, newRow, newCol);
    }

    private boolean isOutSide(int[][] board, int row, int col) {
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0) return true;
        return false;
    }
}