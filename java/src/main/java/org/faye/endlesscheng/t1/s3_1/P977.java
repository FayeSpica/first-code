package org.faye.endlesscheng.t1.s3_1;

public class P977 {
    public int[] sortedSquares(int[] nums) {
        int firstPositiveIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                firstPositiveIndex = i;
                break;
            }
        }

        int[] result = new int[nums.length];

        if (firstPositiveIndex == -1) {
            // 全负数 倒着+
            int right = nums.length - 1;
            while (right >= 0) {
                result[nums.length - 1 - right] = nums[right] * nums[right];
                right--;
            }
        }
        else if (firstPositiveIndex == 0) {
            // 全正数 正着+
            int left = 0;
            while (left <= nums.length - 1) {
                result[left] = nums[left] * nums[left];
                left++;
            }
        }
        else {
            // 一半正 一半负
            // 两个有序数组 归并
            int currentIndex = 0;
            int right = firstPositiveIndex - 1;
            int left = firstPositiveIndex;

            while (right >= 0 && left <= nums.length - 1) {
                int r = nums[right] * nums[right];
                int l = nums[left] * nums[left];
                if (r > l) {
                    // use l
                    result[currentIndex++] = nums[left] * nums[left];
                    left++;
                } else {
                    // use r
                    result[currentIndex++] = nums[right] * nums[right];
                    right--;
                }
            }

            while (right >= 0) {
                result[currentIndex++] = nums[right] * nums[right];
                right--;
            }

            while (left <= nums.length - 1) {
                result[currentIndex++] = nums[left] * nums[left];
                left++;
            }
        }

        return result;
    }
}
