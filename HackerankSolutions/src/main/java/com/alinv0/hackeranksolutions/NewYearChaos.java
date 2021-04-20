package com.alinv0.hackeranksolutions;

import java.util.Arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int sum = 0;

        for (int i = 0; i < q.length; i++) {
            if (q[i] > q[i + 1]) {
                int temp = q[i + 1];
                q[i + 1] = q[i];
                q[i] = temp;
                sum++;
            }
        }

        System.out.println(sum);

        /*int sum = 0;
        for (int i = 0; i < q.length; i++) {
            if(q[i] == i+1){
                continue;
            }
            if (Math.abs(q[i] - (i + 1)) > 2) {
                System.out.println("Too chaotic");
            } else {
                sum++;
            }
        }
        System.out.println("Total perm:" + sum);*/


        /*int[] initial = q;
        heapSort(q);
        Arrays.stream(q).forEach(System.out::println);*/
    }

    static void heapSort(int[] q) {
        int n = q.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(q, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = q[0];
            q[0] = q[i];
            q[i] = temp;

            heapify(q, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i) {
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] q = {1, 2, 5, 3, 4};
        minimumBribes(q);
    }
}
