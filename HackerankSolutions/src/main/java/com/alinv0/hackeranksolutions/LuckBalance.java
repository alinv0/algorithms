package com.alinv0.hackeranksolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {

        List<Integer> importantList = new ArrayList<>();

        int luckSum = 0;
        for (int[] contest : contests) {
            if (contest[1] == 1) {
                importantList.add(contest[0]);
            } else {
                luckSum += contest[0];
            }
        }

        importantList.sort(Collections.reverseOrder());

        for (int i = 0; i < importantList.size(); i++) {
            if (i < k) {
                luckSum += importantList.get(i);
            } else {
                luckSum -= importantList.get(i);
            }
        }

        return luckSum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 1}, {4, 0}, {6, 1}, {2, 1}, {8, 0}};
        luckBalance(2, arr);
    }
}
