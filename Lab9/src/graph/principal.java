package graph;

public class principal {
    public static void main(String[] args) {
        GraphLink g = new GraphLink();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        g.display(); 

        System.out.println("DFS desde A:");
        g.dfs("A");

        g.removeEdge("A", "B");
        System.out.println("\nDespués de remover A-B:");
        g.display();

        g.removeVertex("C");
        System.out.println("Después de remover C:");
        g.display();
    }
}
