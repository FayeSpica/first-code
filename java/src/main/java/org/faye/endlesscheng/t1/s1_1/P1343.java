package org.faye.endlesscheng.t1.s1_1;

public class P1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }

            // update
            int avg = sum / k;
            if (avg >= threshold) {
                counter++;
            }

            // exit
            sum -= arr[i - k + 1];
        }

        return counter;
    }
}
