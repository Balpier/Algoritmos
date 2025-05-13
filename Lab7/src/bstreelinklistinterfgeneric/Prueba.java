package bstreelinklistinterfgeneric;

import Exceptions.ItemDuplicated;
import Exceptions.ItemNoFound;
import Exceptions.ExceptionIsEmpty;

public class Prueba {
    public static void main(String[] args) {
        try {
        
            LinkedBST<Integer> bst = new LinkedBST<>();
            bst.insert(400);
            bst.insert(100);
            bst.insert(700);
            bst.insert(50);
            bst.insert(200);
            bst.insert(75);
            
            System.out.println("\nRecorrido In-Order esperado:");
            bst.inOrder();
            
            System.out.println("\nRecorrido Pre-Order esperado:");
            bst.preOrder();
            
            System.out.println("\nRecorrido Post-Order esperado:");
            bst.postOrder();
            
            System.out.println("\nValor mínimo esperado: 50");
            System.out.println("Mínimo: " + bst.findMin());
            
            System.out.println("\nValor máximo esperado: 700");
            System.out.println("Máximo: " + bst.findMax());
            
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
