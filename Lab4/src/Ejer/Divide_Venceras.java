package Ejer;

import java.util.Random;


public class Divide_Venceras {

    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotValue = arr[pivotIndex];

        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);

        if (k == storeIndex) {
            return arr[storeIndex];
        } else if (k < storeIndex) {
            return quickSelect(arr, left, storeIndex - 1, k);
        } else {
            return quickSelect(arr, storeIndex + 1, right, k);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findKthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {4, 2, 7, 10, 4, 17},
            {4, 2, 7, 10, 4, 1, 6},
            {4, 2, 7, 1, 4, 6},
            {9, 2, 7, 1, 7}
        };
        int[] ks = {3, 5, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Entrada: ");
            for (int num : testCases[i]) {
                System.out.print(num + " ");
            }
            System.out.println(", k = " + ks[i]);
            int result = findKthSmallest(testCases[i], ks[i]);
            System.out.println("Salida: " + result);
            System.out.println();
        }
    }
}