package Ejercicios;

import Actividades.AVLTree;
import Actividades.TreeException;

public class TestRotaciones {

    public static void main(String[] args) throws TreeException {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] secuencia = {30, 20, 10, 25, 28, 27}; 

        for (int e : secuencia) {
            System.out.println("Insertando: " + e);
            avl.insert(e);
            System.out.print("Preorden: ");
            avl.printPreOrder();
            System.out.println();
        }

        System.out.println("Eliminando: 25");
        avl.delete(25);
        avl.printPreOrder();

        System.out.println("Eliminando: 20");
        avl.delete(20);
        avl.printPreOrder();
    }
}
