package org.faye.endlesscheng.t1.s2_1;

public class P1004 {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;

        int zeroCount = 0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            int len = right - left + 1;

            if (len > maxLen) {
                maxLen = len;
            }

            right++;
        }

        return maxLen;
    }
}
