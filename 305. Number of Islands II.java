// https://discuss.leetcode.com/topic/29518/java-python-clear-solution-with-unionfind-class-weighting-and-path-compression
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        FindUnion2D islands = new FindUnion2D(m, n);
        for(int[] position: positions) {
            int x = position[0], y = position[1];
            int p = islands.add(x, y);
            for(int[] dir: dirs) {
                int q = islands.getID(x + dir[0], y + dir[1]);
                if(q > 0 && !islands.find(p, q)) {
                    islands.union(p, q);
                }
            }
            res.add(islands.size());
        }
        return res;
    }
    
    // find and union class
    class FindUnion2D {
        private int[] id, size;     // size is used for weighted quick union
        private int m, n, count;

        public FindUnion2D(int m, int n) {
            this.m = m;
            this.n = n;
            this.id = new int[m * n + 1];
            this.size = new int[m * n + 1];
            this.count = 0;
        }

        public int translate(int x, int y) {
            return x * n + y + 1;
        }

        public int size() {
            return this.count;
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

        public int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];      // path compression
                i = id[i];
            }
            return i;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

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
            count--;
        }
    }
}