package Ejercicios;

public class Ejercicio4 {
    public static <T> int contarNodos(Node<T> head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node<String> lista = new Node<>("A");
        lista.next = new Node<>("D");
        lista.next.next = new Node<>("F");
        System.out.println(contarNodos(lista)); 
    }
}
