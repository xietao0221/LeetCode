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
                int newLand = isLand.add(i, j);
                for(int[] dir: dirs) {
                    int row = i + dir[0], col = j + dir[1];
                    int parameter = isLand.getID(row, col);
                    if(parameter > 0 && !isLand.find(newLand, parameter)) {
                        isLand.union(newLand, parameter);
                    }
                }
            }
        }
        return isLand.size();
    }

    class FindUnion2D {
        private int[] id, size;     // size is used for weighted quick union
        private int m, n, count;    // count is the number of land in the grid

        public FindUnion2D(int m, int n) {
            this.m = m;
            this.n = n;
            id = new int[m * n + 1];       // the default ID for each cell is 0, which means water(set 0)
            size = new int[m * n + 1];
            count = 0;
        }

        // transform 2D matrix into 1D array
        private int translate(int x, int y) {
            return x * n + y + 1;
        }

        // return the size of lands
        public int size() {
            return count;
        }

        // return the ID of this cell
        public int getID(int x, int y) {
            if(x >= 0 && x < m && y >= 0 && y < n) return id[translate(x, y)];
            else return 0;      // water or out of bound(is water as well)
        }

        // create a new land
        public int add(int x, int y) {
            int i = translate(x, y);
            id[i] = i;
            size[i] = 1;
            count++;        // increase the count first, and then check if it is connect to others, if so, decrease it
            return i;
        }

        // find the ID of this cell
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];      // path compression
                i = id[i];
            }
            return i;
        }

        // return true if these two are in the same set
        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        // union these two set
        public void union(int p, int q) {
            int i = root(p), j = root(q);
            // weighted quick union
            if(size[i] < size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
            count--;            // after union, the total lands must be one smaller than before
        }
    }
}
*/