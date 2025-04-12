package Ejer;



public class ViajeBarato {
	public static void main(String[] args) {
        int[][] T = {
            {0,  3,  10, 100, 10},
            {0,  0,   5,  50, 20},
            {0,  0,   0,  10,  5},
            {0,  0,   0,   0,  2},
            {0,  0,   0,   0,  0}
        };

        int n = T.length;
        int[][] C = calcularCostosMinimos(T, n);

        System.out.println("Matriz de Costes Mínimos:");
        imprimirMatriz(C);

        int origen = 0, destino = 4;
        System.out.println("\nCosto mínimo de embarcadero " + origen + " a " + destino + " es: " + C[origen][destino]);
    }

    public static int[][] calcularCostosMinimos(int[][] T, int n) {
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) C[i][j] = 0;
                else if (i < j) C[i][j] = T[i][j];
                else C[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    if (C[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }

        return C;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                if (val == Integer.MAX_VALUE)
                    System.out.print("\t");
                else
                    System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}