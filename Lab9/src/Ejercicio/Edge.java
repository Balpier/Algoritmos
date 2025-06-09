package Ejercicio;

import graph.Vertex;

public class Edge {
    public Vertex destination;
    public Edge next;
    public int weight;

    public Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }
}
