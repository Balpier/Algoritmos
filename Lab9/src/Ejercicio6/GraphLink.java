package Ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphLink {
    private Vertex start;

    public GraphLink() {
        this.start = null;
    }

    private static class Vertex {
        String name;
        Edge adjacency;
        Vertex next;

        Vertex(String name) {
            this.name = name;
            this.adjacency = null;
            this.next = null;
        }
    }

    private static class Edge {
        Vertex destination;
        Edge next;

        Edge(Vertex destination) {
            this.destination = destination;
            this.next = null;
        }
    }


    public void insertVertex(String name) {
        if (!searchVertex(name)) {
            Vertex newVertex = new Vertex(name);
            newVertex.next = start;
            start = newVertex;
        }
    }

    public boolean searchVertex(String name) {
        return getVertex(name) != null;
    }

    private Vertex getVertex(String name) {
        Vertex temp = start;
        while (temp != null) {
            if (temp.name.equals(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void insertEdge(String v1, String v2) {
        Vertex origin = getVertex(v1);
        Vertex dest = getVertex(v2);
        if (origin == null || dest == null || searchEdge(v1, v2)) return;

        Edge e1 = new Edge(dest);
        e1.next = origin.adjacency;
        origin.adjacency = e1;

        Edge e2 = new Edge(origin);
        e2.next = dest.adjacency;
        dest.adjacency = e2;
    }

    public boolean searchEdge(String v1, String v2) {
        Vertex v = getVertex(v1);
        if (v == null) return false;
        Edge e = v.adjacency;
        while (e != null) {
            if (e.destination.name.equals(v2)) return true;
            e = e.next;
        }
        return false;
    }


    public int gradoNodo(String v) {
        Vertex vert = getVertex(v);
        if (vert == null) return -1;

        int count = 0;
        Edge e = vert.adjacency;
        while (e != null) {
            count++;
            e = e.next;
        }
        return count;
    }

    public boolean esCamino() {
        int count1 = 0;
        for (Vertex v = start; v != null; v = v.next) {
            int grado = gradoNodo(v.name);
            if (grado == 1) count1++;
            else if (grado != 2) return false;
        }
        return count1 == 2;
    }

 
    public boolean esCiclo() {
        for (Vertex v = start; v != null; v = v.next) {
            if (gradoNodo(v.name) != 2) return false;
        }
        return true;
    }

    public boolean esRueda() {
        int centro = 0;
        int periferia = 0;
        int n = contarVertices();

        for (Vertex v = start; v != null; v = v.next) {
            int g = gradoNodo(v.name);
            if (g == n - 1) centro++;
            else if (g == 3) periferia++;
            else return false;
        }
        return centro == 1 && periferia == n - 1;
    }


    public boolean esCompleto() {
        int n = contarVertices();
        for (Vertex v = start; v != null; v = v.next) {
            if (gradoNodo(v.name) != n - 1) return false;
        }
        return true;
    }

    public int contarVertices() {
        int count = 0;
        Vertex temp = start;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void display() {
        Vertex v = start;
        while (v != null) {
            System.out.print(v.name + " → ");
            Edge e = v.adjacency;
            while (e != null) {
                System.out.print(e.destination.name + " ");
                e = e.next;
            }
            System.out.println();
            v = v.next;
        }
    }
    
    
    
    public void mostrarFormal() {
        System.out.print("Vértices V = { ");
        for (Vertex v = start; v != null; v = v.next) {
            System.out.print(v.name + " ");
        }
        System.out.println("}");

        Set<String> aristas = new HashSet<>();
        for (Vertex v = start; v != null; v = v.next) {
            for (Edge e = v.adjacency; e != null; e = e.next) {
                String a1 = v.name;
                String a2 = e.destination.name;
                String arista = a1.compareTo(a2) < 0 ? a1 + "-" + a2 : a2 + "-" + a1;
                aristas.add(arista);
            }
        }

        System.out.print("Aristas A = { ");
        for (String a : aristas) {
            System.out.print("(" + a + ") ");
        }
        System.out.println("}");
    }
    
    public void mostrarAdyacencias() {
        for (Vertex v = start; v != null; v = v.next) {
            System.out.print(v.name + " → ");
            for (Edge e = v.adjacency; e != null; e = e.next) {
                System.out.print(e.destination.name + " ");
            }
            System.out.println();
        }
    }
    
    public void mostrarMatrizAdyacencia() {
        List<String> vertices = new ArrayList<>();
        for (Vertex v = start; v != null; v = v.next) {
            vertices.add(v.name);
        }
        Collections.sort(vertices);

        int n = vertices.size();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            Vertex vi = getVertex(vertices.get(i));
            for (Edge e = vi.adjacency; e != null; e = e.next) {
                int j = vertices.indexOf(e.destination.name);
                matriz[i][j] = 1;
            }
        }

        System.out.print("   ");
        for (String col : vertices) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(vertices.get(i) + ": ");
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }



}
