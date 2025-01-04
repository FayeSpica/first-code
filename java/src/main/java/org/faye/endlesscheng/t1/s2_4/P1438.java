package org.faye.endlesscheng.t1.s2_4;

import java.util.TreeMap;

public class P1438 {
    // todo 26%
    public int longestSubarray(int[] nums, int limit) {
        int maxDiffLen = 0;
        int left = 0;
        int right = 1;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[left], 1);

        int diff = Math.abs(map.firstKey() - map.lastKey());
        if (diff <= limit) {
            maxDiffLen = 1;
        }

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (Math.abs(map.firstKey() - map.lastKey()) > limit) {
                int newV = map.get(nums[left]) - 1;
                if (newV == 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], newV);
                }
                left++;
            }

            int diffLen = right - left + 1;
            if (diffLen > maxDiffLen) {
                maxDiffLen = diffLen;
            }
            right++;
        }

        return maxDiffLen;
    }
}
