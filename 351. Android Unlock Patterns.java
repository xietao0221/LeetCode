public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        jump[7][9] = jump[9][7] = 8;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = jump[2][8] = jump[8][2] = jump[4][6] = jump[6][4] = 5;
        
        boolean[] visited = new boolean[10];
        int res = 0;
        
        for(int i = m; i <= n; i++) {
            // 1, 3, 5, 7 are symmetric ==> *4
            res += search(jump, visited, 1, i - 1) * 4;
            
            // 2, 4, 6, 8 are symmetric ==> *4
            res += search(jump, visited, 2, i - 1) * 4;
            
            // 5 is special
            res += search(jump, visited, 5, i - 1);
        }
        return res;
    }
    
    public int search(int[][] jump, boolean[] visited, int curr, int remainNum) {
        if(remainNum < 0) return 0;
        if(remainNum == 0) return 1;
        int res = 0;
        
        visited[curr] = true;
        
        for(int i = 1; i <= 9; i++) {
            // (1) i is visited
            // (2) there is a jump and it is not occured in the previous keys
            if(visited[i] || (jump[curr][i] != 0 && !visited[jump[curr][i]])) continue;
            
            res += search(jump, visited, i, remainNum - 1);
        }
        
        visited[curr] = false;
        return res;
    }
}