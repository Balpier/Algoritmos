package Ejercicio4;


public class JGraphTExample {
    public static void main(String[] args) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.setEdgeWeight(graph.addEdge("A", "B"), 4);
        graph.setEdgeWeight(graph.addEdge("A", "C"), 2);
        graph.setEdgeWeight(graph.addEdge("B", "C"), 1);
        graph.setEdgeWeight(graph.addEdge("B", "D"), 5);
        graph.setEdgeWeight(graph.addEdge("C", "D"), 8);
        graph.setEdgeWeight(graph.addEdge("C", "E"), 10);
        graph.setEdgeWeight(graph.addEdge("D", "E"), 2);

        System.out.println("Vertices: " + graph.vertexSet());
        System.out.println("Aristas: " + graph.edgeSet());

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        GraphPath<String, DefaultWeightedEdge> path = dijkstra.getPath("A", "E");

        System.out.println("\nCamino más corto de A a E:");
        System.out.println("Secuencia: " + path.getVertexList());
        System.out.println("Peso total: " + path.getWeight());
    }
}
