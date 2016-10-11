// DFS: change original grid matrix
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, dirs, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int[][] dirs, int row, int col) {
        // visit this point, make it 'water' to avoid duplicates
        grid[row][col] = '0';
        
        // search 4 directions
        for(int[] dir: dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
                && grid[newRow][newCol] == '1') {
                dfs(grid, dirs, newRow, newCol);    
            }
        }
    }
}

// union and find
/*
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        FindUnion2D isLand = new FindUnion2D(grid.length, grid[0].length);

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0') continue;

                int curr = isLand.add(i, j);
                for(int[] dir: dirs) {
                    int newRow = i + dir[0], newCol = j + dir[1];

                    // if next is 0, it is out of bound
                    int next = isLand.getID(newRow, newCol);
                    if(next != 0 && !isLand.find(curr, next)) {
                        isLand.union(curr, next);
                    }
                }
            }
        }
        return isLand.size();
    }

    class FindUnion2D {
        private int[] id, size;
        private int m, n, count;

        public FindUnion2D(int m, int n) {
            this.m = m;
            this.n = n;
            // the default ID for each cell is 0, which means water(set 0)
            // for this problem, we just add/union land, so others are water
            // because (0,0) could be land, so we use m*n+1 to leave id(0) to be water
            id = new int[m * n + 1];
            size = new int[m * n + 1];
            count = 0;
        }

        private int translate(int x, int y) {
            return x * n + y + 1;
        }

        public int size() {
            return count;
        }

        public int getID(int x, int y) {
            if(x >= 0 && x < m && y >= 0 && y < n) return id[translate(x, y)];
            else return 0;
        }

        public int add(int x, int y) {
            int i = translate(x, y);
            id[i] = i;
            size[i] = 1;
            count++;
            return i;
        }

        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p), j = root(q);
            if(size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
            count--;
        }
    }
}
*/