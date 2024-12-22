package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class LCP28 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count+= right - left;
                count = count % 1000000007;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
