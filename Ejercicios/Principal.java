package Ejercicios;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el tipo de dato a usar:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.print("Opción: ");
        int tipoDato = sc.nextInt();

        if (tipoDato == 1) {
            menuOperacionesInteger(sc);
        } else if (tipoDato == 2) {
            menuOperacionesDouble(sc);
        } else {
            System.out.println("Opción inválida.");
        }

        sc.close();
    }

    public static void menuOperacionesInteger(Scanner sc) {
        OperaMatInteger<Integer> op = new OperaMatInteger<>();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número entero: ");
                int num1 = sc.nextInt();
                System.out.print("Ingrese el segundo número entero: ");
                int num2 = sc.nextInt();

                ejecutarOperacionInteger(op, opcion, num1, num2);
            } else if (opcion >= 5 && opcion <= 7) {
                System.out.print("Ingrese el número entero: ");
                int num = sc.nextInt();
                ejecutarOperacionRaizYPotenciaInteger(op, opcion, num);
            }

        } while (opcion != 8);
    }


    public static void menuOperacionesDouble(Scanner sc) {
        OperaMatDouble<Double> op = new OperaMatDouble<>();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número decimal: ");
                double num1 = sc.nextDouble();
                System.out.print("Ingrese el segundo número decimal: ");
                double num2 = sc.nextDouble();

                ejecutarOperacionDouble(op, opcion, num1, num2);
            } else if (opcion >= 5 && opcion <= 7) {
                System.out.print("Ingrese el número decimal: ");
                double num = sc.nextDouble();
                ejecutarOperacionRaizYPotenciaDouble(op, opcion, num);
            }

        } while (opcion != 8);
    }


    public static void mostrarMenu() {
        System.out.println("Menú de Operaciones:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Producto");
        System.out.println("4. División");
        System.out.println("5. Potencia (x^2)");
        System.out.println("6. Raíz Cuadrada");
        System.out.println("7. Raíz Cúbica");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void ejecutarOperacionInteger(OperaMatInteger<Integer> op, int opcion, int num1, int num2) {
        switch (opcion) {
            case 1 -> System.out.println("Resultado: " + op.sumar(num1, num2));
            case 2 -> System.out.println("Resultado: " + op.restar(num1, num2));
            case 3 -> System.out.println("Resultado: " + op.multiplicar(num1, num2));
            case 4 -> {
                Integer resultado = op.dividir(num1, num2);
                if (resultado != null) System.out.println("Resultado: " + resultado);
            }
        }
    }

    public static void ejecutarOperacionRaizYPotenciaInteger(OperaMatInteger<Integer> op, int opcion, int num) {
        switch (opcion) {
            case 5 -> System.out.println("Potencia (x^2): " + op.potencia(num));
            case 6 -> System.out.println("Raíz Cuadrada: " + op.raizCuadrada(num));
            case 7 -> System.out.println("Raíz Cúbica: " + op.raizCubica(num));
        }
    }

    public static void ejecutarOperacionDouble(OperaMatDouble<Double> op, int opcion, double num1, double num2) {
        switch (opcion) {
            case 1 -> System.out.println("Resultado: " + op.sumar(num1, num2));
            case 2 -> System.out.println("Resultado: " + op.restar(num1, num2));
            case 3 -> System.out.println("Resultado: " + op.multiplicar(num1, num2));
            case 4 -> {
                Double resultado = op.dividir(num1, num2);
                if (resultado != null) System.out.println("Resultado: " + resultado);
            }
        }
    }
    public static void ejecutarOperacionRaizYPotenciaDouble(OperaMatDouble<Double> op, int opcion, Double num) {
        switch (opcion) {
            case 5 -> System.out.println("Potencia (x^2): " + op.potencia(num));
            case 6 -> System.out.println("Raíz Cuadrada: " + op.raizCuadrada(num));
            case 7 -> System.out.println("Raíz Cúbica: " + op.raizCubica(num));
        }
    }

}
