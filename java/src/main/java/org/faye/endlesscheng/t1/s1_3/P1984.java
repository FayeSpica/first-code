package org.faye.endlesscheng.t1.s1_3;

import java.util.Arrays;

public class P1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                continue;
            } else {
                int diff = nums[i] - nums[i - k + 1];
                if (diff < min) {
                    min = diff;
                }
            }
        }

        return min;
    }
}
