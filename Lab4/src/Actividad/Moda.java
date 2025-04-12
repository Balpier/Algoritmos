package Actividad;

public class Moda {

    public static void pivote2(int[] a, int mediana, int prim, int ult, int[] izq, int[] der) {
        int i = prim, j = ult;
        while (i <= j) {
            while (a[i] < mediana) i++;
            while (a[j] > mediana) j--;
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        izq[0] = i;  
        der[0] = j;  
    }

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors homogeneo = new SetVectors();
        SetVectors heterogeneo = new SetVectors();

        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);

        while (!heterogeneo.esVacio()) {
            p = heterogeneo.mayor();
            int mediana = a[(p.prim + p.ult) / 2];

            int[] izq = new int[1], der = new int[1];
            pivote2(a, mediana, p.prim, p.ult, izq, der);

            if (izq[0] <= der[0]) {
                Limits p1 = new Limits(a, p.prim, izq[0] - 1);
                Limits p2 = new Limits(a, izq[0], der[0] - 1);
                Limits p3 = new Limits(a, der[0], p.ult);

                if (p1.prim <= p1.ult) heterogeneo.insertar(p1);
                if (p3.prim <= p3.ult) heterogeneo.insertar(p3);
                if (p2.prim <= p2.ult) homogeneo.insertar(p2);
            }

            heterogeneo.eliminar(p); 
        }

        if (homogeneo.esVacio()) {
            return a[prim];  
        }

        p = homogeneo.mayor();
        return a[p.prim];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 4, 1, 3, 2, 1}; 
        System.out.println("Iniciando el proceso con el arreglo: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int moda = moda3(arr, 0, arr.length - 1);
        System.out.println("La moda es: " + moda);
    }
}