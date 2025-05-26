package Ejercicios;

import Actividades.AVLTree;
import Actividades.TreeException;

public class TestRecorridoAmplitud {

    public static void main(String[] args) {
        try {
            AVLTree<Integer> avl = new AVLTree<>();

            int[] elementos = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};

            for (int e : elementos) {
                avl.insert(e);
            }

            System.out.println("Recorrido por amplitud (nivel por nivel):");
            avl.printLevelOrder(); 

        } catch (TreeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    
}
