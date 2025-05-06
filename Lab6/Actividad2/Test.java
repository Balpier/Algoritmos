package Actividad2;

import Actividades.ExceptionIsEmpty;

public class Test { 

    public static void main(String[] args) throws ExceptionIsEmpty { 
        try { 
            Queue<String> q1 = new QueueLink<String>(); 
            q1.enqueue("Lima"); 
            System.out.println(q1); 
            q1.enqueue("AQP"); 
            System.out.println(q1); 
            q1.enqueue("Cusco"); 
            System.out.println( q1); 
            q1.enqueue("Tacna"); 
            System.out.println( q1 + "\tFront:" + q1.front() + "\tback:" + q1.back()); 
            q1.enqueue("Loreto"); 
            System.out.println( q1); 
            q1.enqueue("Piura"); 
            System.out.println(q1 + "\tFront:" + q1.front() + "\tback:" + q1.back()); 
            q1.enqueue("Ica"); 
            System.out.println( q1); 

            // Eliminar un elemento de la cola (dequeue) 
            String elementoEliminado = q1.dequeue(); 
            System.out.println("Elemento eliminado: " + elementoEliminado); 
            System.out.println("Cola después de dequeue: " + q1); 
        } catch (ExceptionIsEmpty e) { 
            System.out.println(e.getMessage()); 
        } 
    } 
} 