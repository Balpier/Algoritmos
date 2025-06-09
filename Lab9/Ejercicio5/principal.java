package Ejercicio5;

public class principal {
    public static void main(String[] args) {
        GraphLink g = new GraphLink();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("B", "C");
        g.insertEdge("C", "D");
        g.insertEdge("D", "A");

        g.display();

        System.out.println("Grado de B: " + g.gradoNodo("B"));
        System.out.println("¿Es camino?: " + g.esCamino());
        System.out.println("¿Es ciclo?: " + g.esCiclo());
        System.out.println("¿Es rueda?: " + g.esRueda());
        System.out.println("¿Es completo?: " + g.esCompleto());
    }
}
