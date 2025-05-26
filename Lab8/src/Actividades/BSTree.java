package Actividades;


public class BSTree<E extends Comparable<E>> {
    public Node<E> root;
    
    public void insert(E data) throws TreeException {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> node, E data) throws TreeException {
        if (node == null)
            return new Node<>(data);

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        } else {
            throw new TreeException("Elemento duplicado: " + data);
        }

        return node;
    }
}
