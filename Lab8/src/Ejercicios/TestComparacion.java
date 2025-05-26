package Ejercicios;

import Actividades.AVLTree;
import Actividades.BSTree;
import Actividades.Node;
import Actividades.TreeException;

public class TestComparacion {

    public static void main(String[] args) {
        try {
            BSTree<Integer> bst = new BSTree<>();
            AVLTree<Integer> avl = new AVLTree<>();

            int[] elementos = {10, 20, 30, 40, 50};
            for (int e : elementos) {
                bst.insert(e);
                avl.insert(e);
            }

            System.out.println("CASO 1");
            System.out.println("Altura BST: " + height(bst.root));
            System.out.println("Altura AVL: " + height(avl.root));
            System.out.println("BST contiene 40? " + search(bst.root, 40));
            System.out.println("AVL contiene 40? " + search(avl.root, 40));

            bst = new BSTree<>();
            avl = new AVLTree<>();
            int[] elementos2 = {30, 10, 50, 25, 60, 5};
            for (int e : elementos2) {
                bst.insert(e);
                avl.insert(e);
            }

            System.out.println("CASO 2 ");
            System.out.println("Altura BST: " + height(bst.root));
            System.out.println("Altura AVL: " + height(avl.root));
            System.out.println("BST contiene 60? " + search(bst.root, 60));
            System.out.println("AVL contiene 60? " + search(avl.root, 60));

        } catch (TreeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int height(Node<?> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static boolean search(Node<?> node, int key) {
        if (node == null) return false;
        int cmp = key - (Integer) node.data;
        if (cmp == 0) return true;
        else if (cmp < 0) return search(node.left, key);
        else return search(node.right, key);
    }
}
