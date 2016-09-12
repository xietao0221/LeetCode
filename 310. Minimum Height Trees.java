// BFS
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return new ArrayList<>(Arrays.asList(0));
        
        // build edges list
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new HashSet<>());
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // build the first level leaves
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++) {
            if(adj.get(i).size() == 1) leaves.add(i);
        }
        
        // build next level's leaves
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}