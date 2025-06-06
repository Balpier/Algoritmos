package graph;


public class Vertex {
    public String name;
    public Vertex next;
    public Edge adjacency;

    public Vertex(String name) {
        this.name = name;
        this.next = null;
        this.adjacency = null;
    }
}

