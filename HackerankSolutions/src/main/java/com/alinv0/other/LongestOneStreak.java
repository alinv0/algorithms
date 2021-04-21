package com.alinv0.other;

/**
 * Given a binary square matrix of nxn
 * Find longest sequence of 1s on row, column or diagonal
 */
public class LongestOneStreak {
    public static int getMatrixMaxSum(int[][] matrix) {
        int maxSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            maxSum = Math.max(getDiagonalRightUpper(matrix, i), maxSum);
            maxSum = Math.max(getDiagonalLeftLower(matrix, i), maxSum);
            maxSum = Math.max(getDiagonalLeftUpper(matrix, i), maxSum);
            maxSum = Math.max(getDiagonalRightLower(matrix, i), maxSum);
            maxSum = Math.max(getColumnSum(matrix, i), maxSum);
            maxSum = Math.max(getRowSum(matrix, i), maxSum);
        }

        System.out.println("MAX SUM: " + maxSum);
        return maxSum;
    }

    private static int getColumnSum(int[][] matrix, int i) {
        int c = 0;

        StringBuilder sb = new StringBuilder();
        while (c < 5) {
            sb.append(matrix[i][c]);
            c++;
        }

        return getMaxSum(sb);
    }

    private static int getRowSum(int[][] matrix, int i) {
        int r = 0;

        StringBuilder sb = new StringBuilder();
        while (r < 5) {
            sb.append(matrix[r][i]);
            r++;
        }

        return getMaxSum(sb);
    }

    /**
     * [0][0]
     * [0][1] [1][0]
     * [0][2] [1][1] [2][0]
     * [0][3] [1][2] [2][1] [3][0]
     **/
    private static int getDiagonalLeftUpper(int[][] matrix, int i) {
        int d = 0;

        StringBuilder sb = new StringBuilder();
        while (d <= i) {
            sb.append(matrix[d][i - d]);
            d++;
        }

        return getMaxSum(sb);
    }

    /**
     * [5][5]
     * [5][4] [4][5]
     * [5][3] [4][4] [3][5]
     * [5][2] [4][3] [3][4] [2][5]
     */
    private static int getDiagonalRightLower(int[][] matrix, int i) {
        int n = matrix.length - 1;
        int d = 0;

        StringBuilder sb = new StringBuilder();
        while (d <= i) {
            sb.append(matrix[n - d][n - i + d]);
            d++;
        }

        return getMaxSum(sb);
    }

    /**
     * [0][5]
     * [0][4] [1][5]
     * [0][3] [1][4] [2][5]
     * [0][2] [1][3] [2][4] [3][5]
     */

    private static int getDiagonalRightUpper(int[][] matrix, int i) {
        int d = 0;
        int n = matrix.length - 1;

        StringBuilder sb = new StringBuilder();
        while (d <= i) {
            sb.append(matrix[i - d][n - d]);
            d++;
        }

        return getMaxSum(sb);
    }


    /**
     * [5][0]
     * [4][0] [5][1]
     * [3][0] [4][1] [5][2]
     * [2][0] [3][1] [4][2] [5][3]
     */
    private static int getDiagonalLeftLower(int[][] matrix, int i) {
        int n = matrix.length - 1;
        int d = 0;

        StringBuilder sb = new StringBuilder();
        while (d <= i) {
            sb.append(matrix[n - d][i - d]);
            d++;
        }

        return getMaxSum(sb);
    }

    private static int getMaxSum(StringBuilder sb) {
        String[] split = sb.toString().split("0");
        int diagonalSum = 0;
        for (String value : split) {
            if (diagonalSum < value.length()) {
                diagonalSum = value.length();
            }
        }

        return diagonalSum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0}};
        int sum = getMatrixMaxSum(matrix);
        System.out.println(sum);
    }
}
