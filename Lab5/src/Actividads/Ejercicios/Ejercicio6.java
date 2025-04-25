package Ejercicios;

public class Ejercicio6 {
    public static <T> Node<T> concatenarListas(Node<T> l1, Node<T> l2) {
        if (l1 == null) return l2;
        Node<T> actual = l1;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = l2;
        return l1;
    }

    public static void main(String[] args) {
        Node<String> l1 = new Node<>("Hola");
        l1.next = new Node<>("Bienvenido");
        Node<String> l2 = new Node<>("laboratorio");

        Node<String> resultado = concatenarListas(l1, l2);
        while (resultado != null) {
            System.out.print(resultado.data + " ");
            resultado = resultado.next;
        }
    }
}
