package list;


public class ListLinked<T> {
    private Node<T> head;

    public ListLinked() {
        head = null;
    }

    public void insertFirst(T data) {
        head = new Node<T>(data, head);
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T d, Node<T> n) {
            data = d;
            next = n;
        }
    }
}
