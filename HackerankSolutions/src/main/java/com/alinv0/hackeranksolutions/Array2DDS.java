package com.alinv0.hackeranksolutions;

public class Array2DDS {

    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int sum = sumHourglass(getHourglass(i, j, arr));
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    static int sumHourglass(int[] hourglass) {
        int sum = 0;
        for (int j : hourglass) {
            sum += j;
        }
        return sum;
    }

    static int[] getHourglass(int i, int j, int[][] arr) {
        int[] hourglass = new int[7];

        hourglass[0] = arr[i][j];
        hourglass[1] = arr[i][j + 1];
        hourglass[2] = arr[i][j + 2];
        hourglass[3] = arr[i + 1][j + 1];
        hourglass[4] = arr[i + 2][j];
        hourglass[5] = arr[i + 2][j + 1];
        hourglass[6] = arr[i + 2][j + 2];

        return hourglass;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int[][] arr2 = new int[][]{
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };
        System.out.println(hourglassSum(arr2));
        System.out.println(hourglassSum(arr));
    }
}
