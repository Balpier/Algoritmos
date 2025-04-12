package Ejer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubconPotRestringida {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los números separados, incluyendo el objetivo al final:");
        String linea = scanner.nextLine();

        String[] partes = linea.trim().split("\\s+");
        int n = Integer.parseInt(partes[0]);

        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = Integer.parseInt(partes[i + 1]);
        }

        int objetivo = Integer.parseInt(partes[partes.length - 1]);

        boolean resultado = verificarSubconjunto(arreglo, objetivo);
        System.out.println(resultado);
    }

    public static boolean verificarSubconjunto(int[] arreglo, int objetivo) {
        int sumaObligatoria = 0;
        List<Integer> indicesOpcionales = new ArrayList<>();

        for (int i = 0; i < arreglo.length; i++) {
            int num = arreglo[i];

            if (esPotenciaDeDos(num)) {
                sumaObligatoria += num;
            } else if (esMultiploDe5(num) && i + 1 < arreglo.length && arreglo[i + 1] % 2 != 0) {
                continue; 
            } else {
                indicesOpcionales.add(i);
            }
        }

        return puedeSumar(arreglo, indicesOpcionales, 0, sumaObligatoria, objetivo);
    }

    private static boolean puedeSumar(int[] arreglo, List<Integer> indices, int i, int sumaActual, int objetivo) {
        if (sumaActual == objetivo) return true;
        if (i == indices.size()) return false;

        int idx = indices.get(i);
        int valor = arreglo[idx];

        if (puedeSumar(arreglo, indices, i + 1, sumaActual + valor, objetivo)) return true;

        return puedeSumar(arreglo, indices, i + 1, sumaActual, objetivo);
    }

    private static boolean esPotenciaDeDos(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    private static boolean esMultiploDe5(int num) {
        return num % 5 == 0;
    }
}