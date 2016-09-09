public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        UnionFind set = new UnionFind(board.length, board[0].length);
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X' ||
                        (board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1))) {
                    // union all 'X' and all bound 'O' to set 0
                    set.union(set.getID(i, j), 0);
                } else {
                    // union as many 'O' as possible
                    for(int[] dir: dirs) {
                        if(board[i + dir[0]][j + dir[1]] == 'O') {
                            set.union(set.getID(i, j), set.getID(i + dir[0], j + dir[1]));
                        }
                    }
                }
            }
        }
        
        // flip the 'O'
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(!set.find(set.getID(i, j), 0)) board[i][j] = 'X';
            }
        }
    }

    class UnionFind {
        private int[] id, size;
        private int m, n;

        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            id = new int[m * n + 1];
            size = new int[m * n + 1];
            for(int i = 0; i < id.length; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        private int translate(int x, int y) {
            return x * n + y;
        }
    
        public int getID(int x, int y) {
            if(x > 0 || y > 0 || x < m || y < n) return id[translate(x, y)];
            return 0;
        }
    
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }
    
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
    
        public void union(int p, int q) {
            int pi = root(p), qi = root(q);
            if(pi == qi) return;
            if(size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
        }
    }
}