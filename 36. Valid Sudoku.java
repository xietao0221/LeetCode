public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>(), colSet = new HashSet<>(), cubeSet = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
                //check rows
                if(board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                
                //check cols
                if(board[j][i] != '.' && !colSet.add(board[j][i])) return false;
                
                //check cubes
                if(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] != '.' && 
                    !cubeSet.add(board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3])) return false;
            }
        }
        return true;
    }
}