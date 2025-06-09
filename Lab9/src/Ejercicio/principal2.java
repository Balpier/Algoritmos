package Ejercicio;

public class principal2 {
    public static void main(String[] args) {
        GraphLink g = new GraphLink();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");

        g.insertEdgeWeight("A", "B", 4);
        g.insertEdgeWeight("A", "C", 2);
        g.insertEdgeWeight("B", "C", 5);

        g.display(); 
    }
}
