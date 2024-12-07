package org.faye.endlesscheng.t1.s2_1;

public class P1493 {
    public int longestSubarray(int[] nums) {
        int[] counter = new int[2];

        int left = 0;
        int right = 0;

        int maxLen = nums[0];
        counter[nums[0]]++;

        while (right < nums.length) {
            if (counter[0] > 1) {
                counter[nums[left]]--;
                left++;
            } else {
                int max = right - left + 1 - counter[0];
                if (max > maxLen) {
                    maxLen = max;
                }
                right++;
                if (right < nums.length) {
                    counter[nums[right]]++;
                }
            }
        }

        return Math.min(maxLen, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new P1493().longestSubarray(new int[]{1,1,0,1}));
    }
}
