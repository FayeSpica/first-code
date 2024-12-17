package org.faye.endlesscheng.t1.s2_1;

import java.util.Arrays;

public class P2779 {
    // todo
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        // 最大差值小于2k
        int maxLen = 1;

        int left = 0;
        int right = 0;

        int min = nums[0];
        int max = nums[0];
        int targetValue = nums[0];

        while (targetValue <= nums[nums.length - 1]) {
            min = targetValue - k;
            max = targetValue + k;
            while (nums[left] < min) {
                left++;
            }

            while (right + 1 < nums.length && nums[right + 1] <= max) {
                right++;
            }

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }

            targetValue++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
//        System.out.println(new P2779().maximumBeauty(new int[]{4,6,1,2}, 2));
//        System.out.println(new P2779().maximumBeauty(new int[]{1,1,1,1}, 2));
        System.out.println(new P2779().maximumBeauty(new int[]{12, 71}, 10));
    }
}
