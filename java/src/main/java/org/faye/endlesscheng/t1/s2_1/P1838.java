package org.faye.endlesscheng.t1.s2_1;

import java.util.Arrays;

public class P1838 {
    public int maxFrequency(int[] nums, int k) {
        int maxCount = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        long sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (nums[right] * (long)(right - left + 1) > sum + k) {
                sum -= nums[left];
                left++;
            }

            int len = right - left + 1;
            if (len > maxCount) {
                maxCount = len;
            }

            right++;
        }

        return maxCount;
    }
}
