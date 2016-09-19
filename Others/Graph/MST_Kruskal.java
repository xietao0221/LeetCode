// deal with MST using Union and Find, could solve graph with both positive and negative edges
// Time Complexity: O(ElogE + E)
// Space Complexity: O(E + V)
public class Solution {
    public List<String> kruskalMST(List<String> input) {
        Map<String, Vertex> vertice = new HashMap<>();
        Map<String, Integer> positions = new HashMap<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        List<String> res = new ArrayList<>();
        int index = 0;

        // build graph
        for(int i = 0; i < input.size(); i++) {
            String[] edge = input.get(i).split(" ");
            int weight = Integer.parseInt(edge[2]);

            if(!vertice.containsKey(edge[0])) {
                vertice.put(edge[0], new Vertex(edge[0]));
                positions.put(edge[0], index++);
            }
            if(!vertice.containsKey(edge[1])) {
                vertice.put(edge[1], new Vertex(edge[1]));
                positions.put(edge[1], index++);
            }

            Edge edge1 = new Edge(vertice.get(edge[0]), vertice.get(edge[1]), weight);
            Edge edge2 = new Edge(vertice.get(edge[1]), vertice.get(edge[0]), weight);
            vertice.get(edge[0]).neighbors.add(edge1);
            vertice.get(edge[1]).neighbors.add(edge2);

            queue.offer(edge1);
        }

        // initialize Union and Find
        UnionFind uf = new UnionFind(index);
        while(!queue.isEmpty()) {
            if(uf.size() == 1) break;

            Edge curr = queue.poll();
            int p = positions.get(curr.source.str), q = positions.get(curr.destination.str);
            if(!uf.find(p, q)) {
                uf.union(p, q);
                res.add(curr.source.str + "-" + curr.destination.str);
            }
        }
        return res;
    }

    class UnionFind {
        int[] id, size;
        int count;

        public UnionFind(int count) {
            id = new int[count];
            size = new int[count];
            this.count = count;
            for(int i = 0; i < count; i++) {
                id[i] = i;
                size[i] = 1;
            }
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
            if(pi == qi) return;

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

    class Vertex {
        public String str;                                  // vertex name
        public List<Edge> neighbors = new ArrayList<>();    // neighbor edge

        public Vertex(String str) {
            this.str = str;
        }

        public String toString() {
            return str;
        }
    }

    class Edge implements Comparable<Edge> {
        public Vertex source, destination;
        public int weight;

        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        public String toString() {
            return source.str + "->" + destination.str + ":" + weight;
        }
    }
}