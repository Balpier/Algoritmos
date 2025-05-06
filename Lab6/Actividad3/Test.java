package Actividad3;

import Actividades.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> cola = new PriorityQueueLinkSort<>();

            cola.enqueue("Tarea urgente", 5);
            cola.enqueue("Reunión", 3);
            cola.enqueue("Llamar al cliente", 4);
            cola.enqueue("Correo sin apuro", 1);
            cola.enqueue("Estudiar", 4);

            System.out.println("Cola actual:");
            System.out.println(cola); 

            System.out.println("\nElemento al frente (mayor prioridad): " + cola.front());
            System.out.println("Elemento al fondo (menor prioridad): " + cola.back());

            System.out.println("\nEliminando elementos por prioridad:");
            while (!cola.isEmpty()) {
                System.out.println("Dequeue: " + cola.dequeue());
            }

        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}
