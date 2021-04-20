package com.alinv0.hackeranksolutions;

import java.util.Arrays;

public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        int difference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            int dif = arr[i+1]-arr[i];
            if(difference > dif) {
                difference = dif;
            }
            if(difference == 1) {
                return difference;
            }
        }

        return difference;
    }
}
