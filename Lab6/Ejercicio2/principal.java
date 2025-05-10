package Ejercicio2;


import Actividades.ExceptionIsEmpty;

public class principal {
    public static void main(String[] args) {
        try {
            QueueArray<String> cola = new QueueArray<>(5);
            
            cola.enqueue("Lima");
            cola.enqueue("Arequipa");
            cola.enqueue("Cusco");
            System.out.println("Cola actual: " + cola);
            System.out.println("Front: " + cola.front());
            System.out.println("Back: " + cola.back());
            
            cola.dequeue();
            System.out.println("Después de un dequeue: " + cola);
            
            cola.enqueue("Tacna");
            cola.enqueue("Moquegua");
            cola.enqueue("Ayacucho");
            System.out.println("Cola después de agregar más elementos: " + cola);
            System.out.println("Front: " + cola.front());
            System.out.println("Back: " + cola.back());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
