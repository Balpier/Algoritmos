package bstreelinklistinterfgeneric;

public class Node<E extends Comparable<E>> {
    E data;
    Node<E> left, right;

    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}