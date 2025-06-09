package EJericio7;


import java.util.*;

public class GraphLinkDir {
    private Vertex start;

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

        Edge(Vertex dest) {
            this.destination = dest;
            this.next = null;
        }
    }

    public GraphLinkDir() {
        this.start = null;
    }

    public void insertVertex(String name) {
        if (!searchVertex(name)) {
            Vertex v = new Vertex(name);
            v.next = start;
            start = v;
        }
    }

    public void insertEdge(String from, String to) {
        Vertex origin = getVertex(from);
        Vertex dest = getVertex(to);
        if (origin == null || dest == null) return;
        if (searchEdge(from, to)) return;

        Edge e = new Edge(dest);
        e.next = origin.adjacency;
        origin.adjacency = e;
    }

    private Vertex getVertex(String name) {
        for (Vertex v = start; v != null; v = v.next) {
            if (v.name.equals(name)) return v;
        }
        return null;
    }

    public boolean searchVertex(String name) {
        return getVertex(name) != null;
    }

    public boolean searchEdge(String from, String to) {
        Vertex v = getVertex(from);
        if (v == null) return false;
        for (Edge e = v.adjacency; e != null; e = e.next) {
            if (e.destination.name.equals(to)) return true;
        }
        return false;
    }

    // === Métodos de análisis ===

    public int gradoEntrada(String v) {
        int count = 0;
        Vertex target = getVertex(v);
        if (target == null) return -1;
        for (Vertex u = start; u != null; u = u.next) {
            for (Edge e = u.adjacency; e != null; e = e.next) {
                if (e.destination == target) count++;
            }
        }
        return count;
    }

    public int gradoSalida(String v) {
        Vertex origin = getVertex(v);
        if (origin == null) return -1;

        int count = 0;
        for (Edge e = origin.adjacency; e != null; e = e.next) {
            count++;
        }
        return count;
    }

    public boolean esCaminoDirigido() {
        int startNodes = 0;
        int endNodes = 0;
        int intermedios = 0;

        for (Vertex v = start; v != null; v = v.next) {
            int in = gradoEntrada(v.name);
            int out = gradoSalida(v.name);
            if (in == 0 && out == 1) startNodes++;
            else if (in == 1 && out == 0) endNodes++;
            else if (in == 1 && out == 1) intermedios++;
            else return false;
        }

        return startNodes == 1 && endNodes == 1;
    }

    public boolean esCicloDirigido() {
        for (Vertex v = start; v != null; v = v.next) {
            if (gradoEntrada(v.name) != 1 || gradoSalida(v.name) != 1) return false;
        }
        return true;
    }

    public boolean esCompletoDirigido() {
        int n = contarVertices();
        for (Vertex v = start; v != null; v = v.next) {
            if (gradoSalida(v.name) != n - 1) return false;
        }
        return true;
    }

    public int contarVertices() {
        int count = 0;
        for (Vertex v = start; v != null; v = v.next) count++;
        return count;
    }

    public void display() {
        for (Vertex v = start; v != null; v = v.next) {
            System.out.print(v.name + " → ");
            for (Edge e = v.adjacency; e != null; e = e.next) {
                System.out.print(e.destination.name + " ");
            }
            System.out.println();
        }
    }
}
