package Ejercicios;

public class Ejercicio5 {
    public static <T> boolean sonIguales(Node<T> l1, Node<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.data.equals(l2.data)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        a.next = new Node<>(2);
        Node<Integer> b = new Node<>(1);
        b.next = new Node<>(2);

        System.out.println(sonIguales(a, b)); 
    }
}
