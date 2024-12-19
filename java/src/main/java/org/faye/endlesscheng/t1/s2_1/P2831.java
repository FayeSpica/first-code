package org.faye.endlesscheng.t1.s2_1;

import java.util.HashMap;
import java.util.List;

public class P2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        // 满足最多k+1个值不同 最长长度
        int maxLen = 0;

        // 实时记录最高频次的数字 在窗口移动时更新

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums.get(0), 1);

        int left = 0;
        int right = 1;
        while (right < nums.size()) {
            while (map.size() > k + 1) {
                map.put(nums.get(left), map.get(nums.get(left)) - 1);
                if (map.get(nums.get(left)) == 0) {
                    map.remove(nums.get(left));
                }
                left++;
            }

            if (map.size() <= k + 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }
}
