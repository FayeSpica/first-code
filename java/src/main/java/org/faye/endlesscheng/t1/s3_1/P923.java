package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P923 {

    // todo slow 59.50%
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        count+=(k - j + 1) * (k - j) / 2;
                        count = count % 1000000007;
                        j = k;
                    } else {
                        int newJ = j;
                        int newK = k;
                        while (arr[newJ] == arr[j]) {
                            newJ++;
                        }
                        while (arr[newK] == arr[k]) {
                            newK--;
                        }
                        count+=(newJ - j) * (k - newK);
                        count = count % 1000000007;
                        j = newJ;
                        k = newK;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}
