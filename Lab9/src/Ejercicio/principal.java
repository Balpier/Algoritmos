package Ejercicio;

import java.util.ArrayList;

public class principal {
    public static void main(String[] args) {
        GraphLink g = new GraphLink();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");
        g.insertEdge("C", "E");

        System.out.println("Recorrido BFS desde A:");
        g.bfs("A");
       
        System.out.println("");
        ArrayList<String> path = g.bfsPath("A", "E");

        System.out.println("Camino de A a E (BFS): " + path);
        
    }
}

