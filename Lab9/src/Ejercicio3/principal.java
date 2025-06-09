package Ejercicio3;



public class principal {
    public static void main(String[] args) {
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();

        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insertar aristas
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "E");

        System.out.println("=== Grafo: Vértices y Aristas ===");
        graph.display();

        System.out.println("\n¿Existe el vértice 'C'? " + graph.searchVertex("C"));
        System.out.println("¿Existe el vértice 'F'? " + graph.searchVertex("F"));

        System.out.println("\n¿Existe la arista A-B? " + graph.searchEdge("A", "B"));
        System.out.println("¿Existe la arista B-E? " + graph.searchEdge("B", "E"));

        System.out.println("\n=== BFS desde A ===");
        graph.bfs("A");
    }
}
