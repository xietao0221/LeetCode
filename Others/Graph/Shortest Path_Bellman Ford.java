// Time Complexity: O(E * V)
// Space Complexity: O(V)
public class Solution {
    private final int INF = 1000000;

    public List<Vertex> bellmanFord(List<String> input, String startingVertex, String endingVertex) {
        Map<String, Vertex> vertice = new HashMap<>();
        List<Vertex> res = new ArrayList<>();
        Set<Edge> edges = new HashSet<>();

        // build graph
        for(int i = 0; i < input.size(); i++) {
            String[] edge = input.get(i).split(" ");
            int weight = Integer.parseInt(edge[2]);

            if(!vertice.containsKey(edge[0])) vertice.put(edge[0], new Vertex(edge[0]));
            if(!vertice.containsKey(edge[1])) vertice.put(edge[1], new Vertex(edge[1]));

            edges.add(new Edge(vertice.get(edge[0]), vertice.get(edge[1]), weight));
        }

        //
        vertice.get(startingVertex).distance = 0;

        // iterate V-1 times
        for(int i = 0; i < vertice.size() - 1; i++) {
            for(Edge edge: edges) {
                if(edge.source.distance + edge.weight < edge.destination.distance) {
                    edge.destination.distance = edge.source.distance + edge.weight;
                    edge.destination.parent = edge.source;
                }
            }
        }

        // check negative cycle by iterate one more time
        for(Edge edge: edges) {
            if(edge.source.distance + edge.weight < edge.destination.distance) throw new NegativeCycleException();
        }

        // output
        Vertex curr = vertice.get(endingVertex);
        while(curr != vertice.get(startingVertex)) {
            res.add(0, curr);
            curr = curr.parent;
        }
        res.add(0, vertice.get(startingVertex));
        return res;
    }

    class NegativeCycleException extends RuntimeException {}

    class Vertex {
        public String str;                  // vertex name
        public Vertex parent = null;        // the parent vertex on the shortest path
        public int distance = INF;          // the distance between itself and starting point

        public Vertex(String str) {
            this.str = str;
        }

        public String toString() {
            return str + ":" + distance;
        }
    }

    class Edge {
        public Vertex source, destination;
        public int weight;

        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public String toString() {
            return source.str + "->" + destination.str + ":" + weight;
        }
    }
}