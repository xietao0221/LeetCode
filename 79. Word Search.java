public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, dirs, i, j, wordArray, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int[][] dirs, int i, int j, char[] word, int start) {
        if(start == word.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if(board[i][j] == '#' || board[i][j] != word[start]) return false;
        
        char c = board[i][j];
        board[i][j] = '#';          // use '#' to represent this cell is visited
        
        for(int[] dir: dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if(dfs(board, dirs, newRow, newCol, word, start + 1)) return true;
        }
        
        board[i][j] = c;            // backtracking
        return false;
    }
}