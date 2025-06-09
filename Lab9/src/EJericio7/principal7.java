package EJericio7;


public class principal7 {
    public static void main(String[] args) {
        GraphLinkDir g = new GraphLinkDir();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("B", "C");
        g.insertEdge("C", "D");

        g.display();

        System.out.println("Grado entrada de C: " + g.gradoEntrada("C"));
        System.out.println("Grado salida de B: " + g.gradoSalida("B"));
        System.out.println("¿Es camino dirigido?: " + g.esCaminoDirigido());
        System.out.println("¿Es ciclo dirigido?: " + g.esCicloDirigido());
        System.out.println("¿Es completo dirigido?: " + g.esCompletoDirigido());
    }
}
