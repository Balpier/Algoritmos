package graph;


import java.util.*;

public class GraphLink {
    private Vertex start;

    public GraphLink() {
        this.start = null;
    }

    // Método a) insertVertex
    public void insertVertex(String name) {
        if (searchVertex(name)) return;
        Vertex newVertex = new Vertex(name);
        newVertex.next = start;
        start = newVertex;
    }

    // Método a) searchVertex
    public boolean searchVertex(String name) {
        Vertex temp = start;
        while (temp != null) {
            if (temp.name.equals(name)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Método b) searchEdge
    public boolean searchEdge(String v1, String v2) {
        Vertex origin = getVertex(v1);
        if (origin == null) return false;
        Edge e = origin.adjacency;
        while (e != null) {
            if (e.destination.name.equals(v2)) return true;
            e = e.next;
        }
        return false;
    }

    private Vertex getVertex(String name) {
        Vertex temp = start;
        while (temp != null) {
            if (temp.name.equals(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Método insertEdge
    public void insertEdge(String v1, String v2) {
        Vertex origin = getVertex(v1);
        Vertex dest = getVertex(v2);
        if (origin == null || dest == null) return;
        if (searchEdge(v1, v2)) return;

        Edge e1 = new Edge(dest);
        e1.next = origin.adjacency;
        origin.adjacency = e1;

        Edge e2 = new Edge(origin);
        e2.next = dest.adjacency;
        dest.adjacency = e2;
    }

    // Método removeVertex
    public void removeVertex(String name) {
        if (!searchVertex(name)) return;
        Vertex prev = null, curr = start;
        while (curr != null && !curr.name.equals(name)) {
            prev = curr;
            curr = curr.next;
        }

        // Eliminar aristas hacia ese vértice
        Vertex temp = start;
        while (temp != null) {
            if (!temp.name.equals(name)) {
                removeEdge(temp.name, name);
            }
            temp = temp.next;
        }

        // Eliminar el vértice
        if (prev == null) {
            start = curr.next;
        } else {
            prev.next = curr.next;
        }
    }

    // Método removeEdge
    public void removeEdge(String v1, String v2) {
        Vertex origin = getVertex(v1);
        Vertex dest = getVertex(v2);
        if (origin == null || dest == null) return;

        origin.adjacency = removeEdgeFromList(origin.adjacency, v2);
        dest.adjacency = removeEdgeFromList(dest.adjacency, v1);
    }

    private Edge removeEdgeFromList(Edge head, String name) {
        Edge prev = null, curr = head;
        while (curr != null && !curr.destination.name.equals(name)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return head;
        if (prev == null) return curr.next;
        prev.next = curr.next;
        return head;
    }

    // Método dfs
    public void dfs(String v) {
        Set<String> visited = new HashSet<>();
        dfsRecursive(getVertex(v), visited);
    }

    private void dfsRecursive(Vertex v, Set<String> visited) {
        if (v == null || visited.contains(v.name)) return;
        System.out.print(v.name + " ");
        visited.add(v.name);
        Edge e = v.adjacency;
        while (e != null) {
            dfsRecursive(e.destination, visited);
            e = e.next;
        }
    }

    // Método útil para pruebas
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
}
