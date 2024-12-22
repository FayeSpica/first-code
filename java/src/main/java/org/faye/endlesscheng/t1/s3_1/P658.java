package org.faye.endlesscheng.t1.s3_1;

import java.util.ArrayList;
import java.util.List;

public class P658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minAbsSum = Integer.MAX_VALUE;
        int minAbsStart = 0;

        int i = 0;
        int absSum = 0;
        for (; i < k - 1; i++) {
            absSum += Math.abs(arr[i] - x);
        }

        for (; i < arr.length; i++) {
            absSum += Math.abs(arr[i] - x);

            if (absSum < minAbsSum) {
                minAbsSum = absSum;
                minAbsStart = i + 1 - k;
            }

            absSum -= Math.abs(arr[i + 1 - k] - x);
        }

        List<Integer> res = new ArrayList<>();
        for (int j = minAbsStart; j < minAbsStart + k; j++) {
            res.add(arr[j]);
        }

        return res;
    }
}
