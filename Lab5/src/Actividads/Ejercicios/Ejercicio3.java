package Ejercicios;

public class Ejercicio3 {
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor);
        if (head == null) return nuevo;

        Node<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevo;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> lista = new Node<>(1);
        lista = insertarAlFinal(lista, 6);
        lista = insertarAlFinal(lista, 4);

        while (lista != null) {
            System.out.print(lista.data + " ");
            lista = lista.next;
        }
    }
}
