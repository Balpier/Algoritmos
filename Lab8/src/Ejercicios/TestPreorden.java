package Ejercicios;

import Actividades.AVLTree;
import Actividades.TreeException;

public class TestPreorden {

    public static void main(String[] args) throws TreeException {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] elementos = {50, 30, 70, 20, 40, 60, 80};
        for (int e : elementos) {
            avl.insert(e);
        }

        System.out.println("Recorrido en preorden:");
        avl.printPreOrder();
    }
}
