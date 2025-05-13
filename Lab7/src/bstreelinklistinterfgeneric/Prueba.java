package bstreelinklistinterfgeneric;

import Exceptions.ItemDuplicated;


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
            
        } catch (ItemDuplicated e) {
        }
    }
}
