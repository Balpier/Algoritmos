package Actividades;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        BTree<Integer> arbol = new BTree<>(4);  
        int[] claves = {100, 50, 20, 70, 10, 30, 80, 90, 200, 25, 15, 5, 65, 35, 60, 18, 93,94
            
        };

        for (int clave : claves) {
            arbol.insert(clave);
        }

        System.out.println("Árbol B con información estructurada:");
        System.out.println(arbol); 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave que desea buscar: ");
        int claveBuscar = scanner.nextInt();

        boolean encontrado = arbol.search(claveBuscar);
        System.out.println("Resultado: " + encontrado);
        System.out.println(arbol);


        scanner.close();
    }
}
