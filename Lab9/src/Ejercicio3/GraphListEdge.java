package Ejercicio3;

import java.util.*;

public class GraphListEdge<V, E> {
    private ArrayList<VertexObj<V, E>> secVertex;
    private ArrayList<EdgeObj<V, E>> secEdge;

    public GraphListEdge() {
        this.secVertex = new ArrayList<>();
        this.secEdge = new ArrayList<>();
    }

    // a) insertVertex(v)
    public void insertVertex(V v) {
        if (!searchVertex(v)) {
            secVertex.add(new VertexObj<>(v, secVertex.size()));
        }
    }

    // b) insertEdge(v, z)
    public void insertEdge(V v1, V v2) {
        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);
        if (vert1 == null || vert2 == null) return;
        if (searchEdge(v1, v2)) return;

        EdgeObj<V, E> edge = new EdgeObj<>(vert1, vert2, null, secEdge.size());
        secEdge.add(edge);
    }

    // c) searchVertex(v)
    public boolean searchVertex(V v) {
        return getVertex(v) != null;
    }

    private VertexObj<V, E> getVertex(V v) {
        for (VertexObj<V, E> vert : secVertex) {
            if (vert.getInfo().equals(v)) return vert;
        }
        return null;
    }

    // d) searchEdge(v, z)
    public boolean searchEdge(V v1, V v2) {
        VertexObj<V, E> vert1 = getVertex(v1);
        VertexObj<V, E> vert2 = getVertex(v2);
        if (vert1 == null || vert2 == null) return false;

        for (EdgeObj<V, E> edge : secEdge) {
            if (edge.connects(vert1, vert2)) return true;
        }
        return false;
    }

    // e) bfs(v)
    public void bfs(V v) {
        VertexObj<V, E> start = getVertex(v);
        if (start == null) return;

        Set<VertexObj<V, E>> visited = new HashSet<>();
        Queue<VertexObj<V, E>> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            VertexObj<V, E> current = queue.poll();
            System.out.print(current.getInfo() + " ");

            for (EdgeObj<V, E> edge : secEdge) {
                VertexObj<V, E> neighbor = null;
                if (edge.endVertex1 == current && !visited.contains(edge.endVertex2)) {
                    neighbor = edge.endVertex2;
                } else if (edge.endVertex2 == current && !visited.contains(edge.endVertex1)) {
                    neighbor = edge.endVertex1;
                }

                if (neighbor != null) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public void display() {
        System.out.println("Vértices:");
        for (VertexObj<V, E> v : secVertex) {
            System.out.println("- " + v.getInfo());
        }

        System.out.println("Aristas:");
        for (EdgeObj<V, E> e : secEdge) {
            System.out.println("- (" + e.endVertex1.getInfo() + " - " + e.endVertex2.getInfo() + ")");
        }
    }
}
