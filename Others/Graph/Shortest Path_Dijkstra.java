// deal with shortest path problem using Priority Queue. Cannot deal with graph with negative edges.
// Dijikstra is similar to Prim MST, Dijikstra focus on the distance between starting point and itself, rather than every connect weight.
// Time Complexity: O(VlogE)
// Space Complexity: O(V + E)
public class Solution {
    // the first line is starting point
    // the rest of lines are edges based on the rule: "vertex1 vertex2 weight"
    public List<Vertex> dijikstra(List<String> input) {
        Map<String, Vertex> vertice = new HashMap<>();          // <vertex name, vertex obj>
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Set<Vertex> res = new HashSet<>();

        // build graph
        Vertex startingPoint = new Vertex(input.get(0));
        vertice.put(startingPoint.str, startingPoint);
        for(int i = 1; i < input.size(); i++) {
            String[] edge = input.get(i).split(" ");
            int weight = Integer.parseInt(edge[2]);

            if(!vertice.containsKey(edge[0])) vertice.put(edge[0], new Vertex(edge[0]));
            if(!vertice.containsKey(edge[1])) vertice.put(edge[1], new Vertex(edge[1]));

            vertice.get(edge[0]).neighbors.add(new Edge(vertice.get(edge[0]), vertice.get(edge[1]), weight));
            vertice.get(edge[1]).neighbors.add(new Edge(vertice.get(edge[1]), vertice.get(edge[0]), weight));
        }

        // offer all vertex into Priority Queue
        startingPoint.distance = 0;
        for(Vertex vertex: vertice.values()) queue.offer(vertex);

        // BFS with PriorityQueue
        // each time poll out the smallest distance(itself->startingPoint)
        while(!queue.isEmpty()) {
            Vertex curr = queue.poll();
            res.add(curr);
            for(Edge edge: curr.neighbors) {

                // if(!queue.contains(edge.destination)) continue;  // avoid use PQ's contain: O(n) complexity
                if(res.contains(edge.destination)) continue;

                int currDist = curr.distance + edge.weight;
                if(currDist < edge.destination.distance) {
                    // cannot change PriorityQueue's key, we have to remove it and insert it again
                    queue.remove(edge.destination);

                    // change parent vertex and distance
                    edge.destination.distance = currDist;
                    edge.destination.parent = curr;

                    // insert it again
                    queue.offer(edge.destination);
                }
            }
        }
        return new ArrayList<>(res);
    }

    class Vertex implements Comparable<Vertex> {
        public String str;                                  // vertex name
        public List<Edge> neighbors = new ArrayList<>();    // neighbor edge
        public Vertex parent = null;                        // the parent vertex on shortest path
        public int distance = Integer.MAX_VALUE;            // the distance to starting point on shortest path

        public Vertex(String str) {
            this.str = str;
        }

        public int compareTo(Vertex other) {
            return this.distance - other.distance;
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