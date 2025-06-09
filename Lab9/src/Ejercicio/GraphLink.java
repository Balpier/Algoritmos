package Ejercicio;


import java.util.*;

import graph.Edge;
import graph.Vertex;

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
    
    public void bfs(String v) {
        Vertex startVertex = getVertex(v);
        if (startVertex == null) return;

        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(startVertex.name);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.name + " ");

            Edge edge = current.adjacency;
            while (edge != null) {
                Vertex neighbor = edge.destination;
                if (!visited.contains(neighbor.name)) {
                    visited.add(neighbor.name);
                    queue.offer(neighbor);
                }
                edge = edge.next;
            }
        }
    }
    
    public ArrayList<String> bfsPath(String v, String z) {
        ArrayList<String> path = new ArrayList<>();
        Vertex start = getVertex(v);
        Vertex goal = getVertex(z);

        if (start == null || goal == null) return path;

        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();

        visited.add(v);
        queue.offer(start);
        parent.put(v, null); 

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            if (current.name.equals(z)) break;

            Edge edge = current.adjacency;
            while (edge != null) {
                Vertex neighbor = edge.destination;
                if (!visited.contains(neighbor.name)) {
                    visited.add(neighbor.name);
                    parent.put(neighbor.name, current.name);
                    queue.offer(neighbor);
                }
                edge = edge.next;
            }
        }
        // Reconstruir

        if (!parent.containsKey(z)) 
        	return path;

        String step = z;
        while (step != null) {
            path.add(0, step); 
            step = parent.get(step);
        }

        return path;
    }
    
    
    
    public void insertEdgeWeight(String v, String z, int w) {
        Vertex origin = getVertex(v);
        Vertex dest = getVertex(z);
        if (origin == null || dest == null) return;
        if (searchEdge(v, z)) return;

        Edge e1 = new Edge(dest, w);
        e1.next = origin.adjacency;
        origin.adjacency = e1;

        Edge e2 = new Edge(origin, w);
        e2.next = dest.adjacency;
        dest.adjacency = e2;
    }
    
    public ArrayList<String> shortPath(String v, String z) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<VertexDist> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        for (Vertex temp = start; temp != null; temp = temp.next) {
            dist.put(temp.name, Integer.MAX_VALUE);
            prev.put(temp.name, null);
        }

        dist.put(v, 0);
        pq.offer(new VertexDist(v, 0));

        while (!pq.isEmpty()) {
            VertexDist current = pq.poll();
            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            Vertex vertex = getVertex(current.name);
            Edge edge = vertex.adjacency;

            while (edge != null) {
                String neighbor = edge.destination.name;
                int newDist = dist.get(current.name) + edge.weight;

                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, current.name);
                    pq.offer(new VertexDist(neighbor, newDist));
                }

                edge = edge.next;
            }
        }

        ArrayList<String> path = new ArrayList<>();
        if (!dist.containsKey(z) || dist.get(z) == Integer.MAX_VALUE) return path;

        String current = z;
        while (current != null) {
            path.add(0, current);
            current = prev.get(current);
        }

        return path;
    }

    private static class VertexDist {
        String name;
        int dist;

        VertexDist(String name, int dist) {
            this.name = name;
            this.dist = dist;
        }
    }




}
