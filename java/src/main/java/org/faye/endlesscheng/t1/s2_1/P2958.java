package org.faye.endlesscheng.t1.s2_1;

import java.util.HashMap;

public class P2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxLen = 1;

        int left = 0;
        int right = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[left], 1);

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
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
