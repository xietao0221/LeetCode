public class Solution {
    public int countComponents(int n, int[][] edges) {
        // create and initialize roots array
        int[] roots = new int[n];
        for(int i = 0; i < n; i++) roots[i] = i;
        
        // union and find
        for(int[] e: edges) {
            int root1 = getRoot(roots, e[0]), root2 = getRoot(roots, e[1]);
            if(root1 != root2) roots[root1] = root2;
        }
        
        for(int i = 0; i < roots.length; i++) {
            if(roots[i] != i) n--;
        }
        return n;
    }
    
    public int getRoot(int[] roots, int index) {
        while(index != roots[index]) {
            roots[index] = roots[roots[index]];
            index = roots[index];
        }
        return index;
    }
}