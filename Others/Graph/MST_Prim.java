// deal with MST problem using Priority Queue, similar to Dijkstra, but Prim focus on the connect weight rather than the 
// weight from starting point to itself. Could solve graph with both positive and negative edges
// Time Complexity: O(ElogV)
// Space Complexity: O(E + V)
public class Solution {
    public List<String> primMST(List<String> input) {
        Map<String, Vertex> vertice = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Set<Vertex> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        Vertex startingVertex = null;

        // build graph
        for(int i = 0; i < input.size(); i++) {
            String[] edge = input.get(i).split(" ");
            int weight = Integer.parseInt(edge[2]);

            if(!vertice.containsKey(edge[0])) vertice.put(edge[0], new Vertex(edge[0]));
            if(!vertice.containsKey(edge[1])) vertice.put(edge[1], new Vertex(edge[1]));

            vertice.get(edge[0]).neighbors.add(new Edge(vertice.get(edge[0]), vertice.get(edge[1]), weight));
            vertice.get(edge[1]).neighbors.add(new Edge(vertice.get(edge[1]), vertice.get(edge[0]), weight));

            if(i == 0) startingVertex = vertice.get(edge[0]);
        }

        // put all vertice into priority queue
        for(Vertex curr: vertice.values()) queue.offer(curr);
        startingVertex.distance = 0;

        //
        while(!queue.isEmpty()) {
            Vertex curr = queue.poll();
            visited.add(curr);

            for(Edge edge: curr.neighbors) {
                if(visited.contains(edge.destination)) continue;

                if(edge.weight < edge.destination.distance) {
                    queue.remove(edge.destination);

                    edge.destination.distance = edge.weight;
                    edge.destination.introduceBy = curr;

                    queue.offer(edge.destination);
                }
            }
        }

        // output the result

        for(Vertex curr: visited) res.add(curr.str + "-" + (curr.introduceBy == null ? "" : curr.introduceBy.str));
        return res;
    }


    class Vertex implements Comparable<Vertex> {
        public String str;                                  // vertex name
        public List<Edge> neighbors = new ArrayList<>();    // neighbor edge
        public Vertex introduceBy = null;                   // the introduce vertex on MST
        public int distance = Integer.MAX_VALUE;            // the distance between itself and introduce vertex

        public Vertex(String str) {
            this.str = str;
        }

        public int compareTo(Vertex other) {
            return this.distance - other.distance;
        }

        public String toString() {
            return str;
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