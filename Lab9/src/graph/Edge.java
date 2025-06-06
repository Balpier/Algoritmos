package graph;


public class Edge {
    public Vertex destination;
    public Edge next;

    public Edge(Vertex destination) {
        this.destination = destination;
        this.next = null;
    }
}
