package org.faye.endlesscheng.t1.s2_1;

public class P1658 {
    // todo:
    public int minOperations(int[] nums, int x) {
        // 和为x的连续子数组，必须包含num.length - 1
        // 1 1 1 1 2 3 1  -- 5
        int minLength = Integer.MAX_VALUE;

        int[] nums2 = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
            nums2[i + nums.length] = nums[i];
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < nums.length && right < nums2.length && right - nums.length <= left) {
            sum += nums2[right];
            while (sum > x && left < nums.length && left <= right) {
                sum -= nums2[left];
                left++;
            }

            if (sum == x && (right >= nums.length - 1 || left == 0)) {
                int len = right - left + 1;
                if (len < minLength && len <= nums.length) {
                    minLength = len;
                }
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
