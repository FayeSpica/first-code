package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;

        // a < b + c
        for (int c = 2; c < nums.length; c++) {
            int a = 0;
            int b = c - 1;

            // 2 2 2 3 4
            // 2 3 4 4

            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    // hit
                    counter+= b - a;
                    b--;
                } else {
                    a++;
                }
            }
        }

        return counter;
    }
}
