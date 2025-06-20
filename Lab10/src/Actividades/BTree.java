package Actividades;


public class BTree<E extends Comparable<E>> {

    private BNode<E> root;     
    private int orden;         
    private boolean up;       
    private BNode<E> nDes;     

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> nuevo;

        mediana = push(this.root, cl);

        if (up) {
            nuevo = new BNode<>(orden);
            nuevo.count = 1;
            nuevo.keys.set(0, mediana);
            nuevo.childs.set(0, this.root);
            nuevo.childs.set(1, nDes);
            this.root = nuevo;
        }
    }

    private E push(BNode<E> actual, E cl) {
        int[] pos = new int[1];
        E mediana;

        if (actual == null) {
            up = true;
            nDes = null;
            return cl; 
        } else {
            boolean existe = actual.searchNode(cl, pos);
            if (existe) {
                System.out.println("Clave duplicada: " + cl);
                up = false;
                return null;
            }

            mediana = push(actual.childs.get(pos[0]), cl);

            if (up) {
                if (actual.nodeFull(orden - 1)) {
                    mediana = dividedNode(actual, mediana, pos[0]);
                } else {
                    putNode(actual, mediana, nDes, pos[0]);
                    up = false;
                }
            }
            return mediana;
        }
    }
    //Inserta una clave y su hijo derecho
    private void putNode(BNode<E> nodo, E clave, BNode<E> derecho, int k) {
        for (int i = nodo.count - 1; i >= k; i--) {
            nodo.keys.set(i + 1, nodo.keys.get(i));
            nodo.childs.set(i + 2, nodo.childs.get(i + 1));
        }
        nodo.keys.set(k, clave);
        nodo.childs.set(k + 1, derecho);
        nodo.count++;
    }

    private E dividedNode(BNode<E> nodo, E clave, int k) {
        BNode<E> derecho = nDes;
        int i, posMediana;

        posMediana = (k <= orden / 2) ? orden / 2 : orden / 2 + 1;

        nDes = new BNode<>(orden);
        for (i = posMediana; i < orden - 1; i++) {
            nDes.keys.set(i - posMediana, nodo.keys.get(i));
            nDes.childs.set(i - posMediana + 1, nodo.childs.get(i + 1));
        }

        nDes.count = (orden - 1) - posMediana;
        nodo.count = posMediana;

        if (k <= orden / 2) {
            putNode(nodo, clave, derecho, k);
        } else {
            putNode(nDes, clave, derecho, k - posMediana);
        }

        E mediana = nodo.keys.get(nodo.count - 1);
        nDes.childs.set(0, nodo.childs.get(nodo.count));
        nodo.count--;

        return mediana;
    }
    
    @Override
   
    public String toString() {
        if (isEmpty()) return "El árbol B está vacío.";
        return printHierarchical();
    }

    //recorre el árbol y lo convierte a texto
    private String writeTree(BNode<E> current) {
        StringBuilder sb = new StringBuilder();
        writeTreeRecursive(current, null, sb);
        return sb.toString();
    }
    
    //Recorre el árbol mostrando claves, hijos y padres
    private void writeTreeRecursive(BNode<E> current, BNode<E> parent, StringBuilder sb) {
        if (current == null) return;

        sb.append("Id.Nodo: ").append(current.getIdNode()).append("\n");

        sb.append("Claves Nodo: ").append(current.getKeys().subList(0, current.getCount())).append("\n");

        if (parent != null) {
            sb.append("Id.Padre: ").append(parent.getIdNode()).append("\n");
        } else {
            sb.append("Id.Padre: --\n");
        }

        StringBuilder hijos = new StringBuilder();
        for (int i = 0; i <= current.getCount(); i++) {
            BNode<E> hijo = current.getChilds().get(i);
            if (hijo != null) {
                hijos.append(hijo.getIdNode()).append(", ");
            }
        }

        if (hijos.length() > 0) {
            hijos.setLength(hijos.length() - 2); 
            sb.append("Id.Hijos: [").append(hijos).append("]\n");
        } else {
            sb.append("Id.Hijos: --\n");
        }

        sb.append("\n");

       for (int i = 0; i <= current.getCount(); i++) {
            BNode<E> hijo = current.getChilds().get(i);
            if (hijo != null) {
                writeTreeRecursive(hijo, current, sb);
            }
        }
    }
    
    public boolean search(E cl) {
        return searchRecursive(this.root, cl);
    }

    private boolean searchRecursive(BNode<E> current, E cl) {
        if (current == null) {
            return false;
        }

        int pos = 0;
        while (pos < current.getCount() && cl.compareTo(current.getKeys().get(pos)) > 0) {
            pos++;
        }

        if (pos < current.getCount() && cl.compareTo(current.getKeys().get(pos)) == 0) {
            System.out.println(cl + " se encuentra en el nodo " + current.getIdNode() + " en la posición " + pos);
            return true;
        }

        return searchRecursive(current.getChilds().get(pos), cl);
    }

   



}
