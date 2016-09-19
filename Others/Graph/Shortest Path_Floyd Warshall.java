// deal with shortest path for the graph with negative weight using DP
// Time Complexity: O(V^3)
// Space Complexity: O(V^2)
public class Solution {
    public static final int INF = 1000000;

    public List<Integer> floydWarshall(int[][] edges, int start, int end) {
        int[][] distance = new int[edges.length][edges[0].length];
        int[][] path = new int[edges.length][edges[0].length];

        // initialize distance and path
        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[0].length; j++) {
                distance[i][j] = edges[i][j];

                if(i != j && edges[i][j] != INF) path[i][j] = i;
                else path[i][j] = -1;
            }
        }

        // check if detouring to k could improve the distance: distance[i][k] + distance[k][j] < distance[i][j]
        for(int k = 0; k < edges.length; k++) {
            for(int i = 0; i < edges.length; i++) {
                for(int j = 0; j < edges.length; j++) {
                    if(distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        // detect negative cycle
        for(int i = 0; i < edges.length; i++) {
            if(distance[i][i] < 0) throw new NegativeCycleException();
        }

        // output path
        return output(path, start, end);
    }

    private List<Integer> output(int[][] path, int start, int end) {
        List<Integer> res = new ArrayList<>();
        res.add(0, end);
        int parent = path[start][end];
        while(parent != start) {
            res.add(0, parent);
            parent = path[start][parent];
        }
        res.add(0, start);
        return res;
    }

    class NegativeCycleException extends RuntimeException {}
}