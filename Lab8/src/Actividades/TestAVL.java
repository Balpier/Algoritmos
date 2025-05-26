package Actividades;


public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        int[] valores = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};

        try {
            for (int val : valores) {
                tree.insert(val);
                System.out.println("Insertado: " + val);
            }
        } catch (TreeException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
