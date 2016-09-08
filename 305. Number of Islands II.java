// https://discuss.leetcode.com/topic/29518/java-python-clear-solution-with-unionfind-class-weighting-and-path-compression
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        FindUnion2D islands = new FindUnion2D(m, n);
        
        for(int[] position: positions) {
            // create a new land
            int x = position[0], y = position[1];
            int newLand = islands.add(x, y);
            
            // search its perameters to check if this new land union other land
            for(int[] dir: dirs) {
                int parameterLand = islands.getID(x + dir[0], y + dir[1]);
                if(parameterLand > 0 && !islands.find(newLand, parameterLand)) {
                    islands.union(newLand, parameterLand);
                }
            }
            res.add(islands.size());
        }
        return res;
    }
    
    // find and union class
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