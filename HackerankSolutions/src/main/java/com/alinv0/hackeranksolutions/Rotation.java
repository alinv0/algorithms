package com.alinv0.hackeranksolutions;

public class Rotation {

    /**
     * Loop left once for several times
     * @param a
     * @param d
     * @return
     */
    static int[] rotLeft(int[] a, int d) {
        if (d == 0 || a.length == 0) {
            return a;
        }
        while(d > 0) {
            shiftLeft(a);
            d--;
        }
        return a;
    }

    /**
     * x = Substring from 0->d
     * y = Substring from d->a.length
     * shift y d%a.length positions
     * assign x to positions from y.length to a.length
     *
     * @return
     */
    static int[] rotLeftOptimised(int[] a, int d) {
        return null;
    }

    private static void shiftLeft(int[] a) {
        int atemp = a[0];
        for(int i = 1; i< a.length; i++) {
            a[i-1] = a[i];
        }
        a[a.length-1] = atemp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        a = rotLeft(a, 13);
        System.out.println(a);
    }
}
