package com.alinv0.hackeranksolutions;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        int swapCount = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j);
                    swapCount++;
                }
            }
        }

        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    private static void swap(int[] a, int j) {
        int temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{3, 2, 1});
    }
}
