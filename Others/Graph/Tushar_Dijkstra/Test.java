import java.util.*;
public class Test {
    public static void main (String[] args) {
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        DijkstraShortestPath dsp = new DijkstraShortestPath();
        Vertex<Integer> sourceVertex = graph.getVertex(1);
        Map<Vertex<Integer>,Integer> distance = dsp.shortestPath(graph, sourceVertex);
        System.out.print(distance);
    }
}