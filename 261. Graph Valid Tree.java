public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind set = new UnionFind(n);
        for(int[] edge: edges) {
            if(set.find(edge[0], edge[1])) return false;
            set.union(edge[0], edge[1]);
        }
        return set.size() == 1;
    }
    
    class UnionFind {
        private int[] id, size;
        private int count;
        
        public UnionFind(int len) {
            id = new int[len];
            size = new int[len];
            for(int i = 0; i < len; i++) {
                id[i] = i;
                size[i] = 1;
            }
            count = len;
        }
        
        public int size() {
            return count;
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
            int pi = root(p), qi = root(q);
            if(size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
            }
            count--;
        }
    }
}