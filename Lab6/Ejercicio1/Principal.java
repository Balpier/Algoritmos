package Ejercicio1;

import Actividades.ExceptionIsEmpty;
import Actividades.Stack;

public class Principal {
    public static void main(String[] args) {
        try {
        
            Stack<Integer> pilaInt = new StackLink<>();
            pilaInt.push(10);
            pilaInt.push(20);
            pilaInt.push(30);
            System.out.println("Pila de enteros: " + pilaInt);
            System.out.println("Top: " + pilaInt.top());
            System.out.println("Pop: " + pilaInt.pop());
            System.out.println("Después del pop: " + pilaInt);

            Stack<String> pilaString = new StackLink<>();
            pilaString.push("Laboratorio 6");
            pilaString.push("Bienvenidos");
            pilaString.push("hola");
            System.out.println("\nPila de cadenas: " + pilaString);
            System.out.println("Top: " + pilaString.top());
            System.out.println("Pop: " + pilaString.pop());
            System.out.println("Después del pop: " + pilaString);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
