public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(word.charAt(0) == board[i][j] && 
                    search(board, visited, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, boolean[][] visited, int i, int j, String word, int start) {
        if(start == word.length()) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] ||
            word.charAt(start) != board[i][j]) return false;
            
        boolean res = true;
        visited[i][j] = true;
        res = search(board, visited, i+1, j, word, start+1) || 
            search(board, visited, i-1, j, word, start+1) || 
            search(board, visited, i, j+1, word, start+1) || 
            search(board, visited, i, j-1, word, start+1);
        visited[i][j] = false;      // backtracking
        return res;
    }
}