package Actividades;


import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    private static int nodeCounter = 0; 

    public ArrayList<E> keys;
    public ArrayList<BNode<E>> childs;
    public int count;
    protected int idNode;

    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1);
        this.count = 0;
        this.idNode = nodeCounter++;

        for (int i = 0; i < n - 1; i++) keys.add(null);
        for (int i = 0; i < n; i++) childs.add(null);
    }

   
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }


    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        int i = 0;
        while (i < count && key.compareTo(keys.get(i)) > 0) i++;
        pos[0] = i;

        if (i < count && key.compareTo(keys.get(i)) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodo ID ").append(idNode).append(": [");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public int getIdNode() {
        return idNode;
    }

    public ArrayList<E> getKeys() {
        return keys;
    }

    public ArrayList<BNode<E>> getChilds() {
        return childs;
    }

    public int getCount() {
        return count;
    }
}
