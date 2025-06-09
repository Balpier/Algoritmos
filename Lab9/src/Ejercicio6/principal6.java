package Ejercicio6;

public class principal6 {
    public static void main(String[] args) {
        GraphLink g = new GraphLink();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        System.out.println("=== Representación Formal ===");
        g.mostrarFormal();

        System.out.println("\n=== Lista de Adyacencias ===");
        g.mostrarAdyacencias();

        System.out.println("\n=== Matriz de Adyacencia ===");
        g.mostrarMatrizAdyacencia();
    }
}
