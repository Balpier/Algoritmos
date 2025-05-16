package Ejercicio;



import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import Exceptions.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> bst = new LinkedBST<>();
            
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            
            System.out.println("Probando destroyNodes()");
            bst.destroyNodes();
            System.out.println("Árbol destruido correctamente.");
            
            // Reinserción para las siguientes pruebas
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            
            System.out.println("Total de nodos no-hoja: " + bst.countAllNodes()); // Debería ser 3
            
            System.out.println("Total de nodos: " + bst.countNodes()); // Debería ser 7
            
            System.out.println("Altura del nodo 50: " + bst.height(50)); // Debería ser 2
            System.out.println("Altura del nodo 30: " + bst.height(30)); // Debería ser 1
            System.out.println("Altura del nodo 80: " + bst.height(80)); // Debería ser 0
            
            System.out.println("Amplitud del nivel 0: " + bst.amplitude(0)); // Debería ser 1
            System.out.println("Amplitud del nivel 1: " + bst.amplitude(1)); // Debería ser 2
            System.out.println("Amplitud del nivel 2: " + bst.amplitude(2)); // Debería ser 4
            
        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
