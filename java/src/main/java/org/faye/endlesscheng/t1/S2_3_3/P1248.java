package org.faye.endlesscheng.t1.S2_3_3;

import java.util.Arrays;

public class P1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2== 1) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }

        // 和为k的数量
        // 0 0 0 1 0 0 1 0 1 0

        System.out.println(Arrays.toString(nums));

        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P1248().numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
    }
}
