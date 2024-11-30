package org.faye.endlesscheng.t1;

public class P1151 {
    public int minSwaps(int[] data) {
        int min = Integer.MAX_VALUE;
        // 确定k的长度
        int k = 0;
        for (int i = 0; i < data.length; i++) {
            k += data[i];
        }

        if (k == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count += data[i];
            if (i < k - 1) {
                continue;
            }

            int cMin = k - count;
            if (cMin < min) {
                min = cMin;
            }

            count -= data[i - k + 1];
        }

        return min;
    }
}
