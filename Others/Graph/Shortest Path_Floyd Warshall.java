// deal with shortest path for the graph(DAG) with negative weight using DP
// Time Complexity: O(V^3)
// Space Complexity: O(V^2)
public class Solution {
    public static final int INF = 1000000;

    public List<String> floydWarshall(List<String> input, String startingPoint, String endingPoint) {
        Map<String, Integer> positions = new HashMap<>();               // String -> int
        Map<Integer, String> map = new HashMap<>();                     // int -> String
        Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();    // <u, <v, weight[u, v]>>

        // build string->int and int->string map, and build edges(DAG)
        int index = 0;
        for(int i = 0; i < input.size(); i++) {
            String[] edge = input.get(i).split(" ");
            int weight = Integer.parseInt(edge[2]);

            if(!positions.containsKey(edge[0])) {
                positions.put(edge[0], index++);
                map.put(index - 1, edge[0]);
            }
            if(!positions.containsKey(edge[1])) {
                positions.put(edge[1], index++);
                map.put(index - 1, edge[1]);
            }

            if(!edges.containsKey(positions.get(edge[0]))) edges.put(positions.get(edge[0]), new HashMap<>());
            edges.get(positions.get(edge[0])).put(positions.get(edge[1]), weight);
        }

        // initialize distance and path
        int[][] distance = new int[index][index];
        int[][] path = new int[index][index];
        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance.length; j++) {
                if(edges.containsKey(i) && edges.get(i).containsKey(j)) distance[i][j] = edges.get(i).get(j);
                else distance[i][j] = INF;

                if(i != j && distance[i][j] != INF) path[i][j] = i;
                else path[i][j] = -1;
            }
        }

        // check if detouring to k could improve the distance: distance[i][k] + distance[k][j] < distance[i][j]
        for(int k = 0; k < distance.length; k++) {
            for(int i = 0; i < distance.length; i++) {
                for(int j = 0; j < distance.length; j++) {
                    if(distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        // detect negative cycle
        for(int i = 0; i < distance.length; i++) {
            if(distance[i][i] < 0) throw new NegativeCycleException();
        }

        // output path
        return output(path, positions.get(startingPoint), positions.get(endingPoint), map);
    }

    private List<String> output(int[][] path, int start, int end, Map<Integer, String> map) {
        List<String> res = new ArrayList<>();
        res.add(0, map.get(end));
        int parent = path[start][end];
        while(parent != start) {
            res.add(0, map.get(parent));
            parent = path[start][parent];
        }
        res.add(0, map.get(start));
        return res;
    }

    class NegativeCycleException extends RuntimeException {}
}