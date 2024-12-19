package org.faye.endlesscheng.t1.s2_1;

import java.util.*;

public class P2831 {

    // todo slow
    public int longestEqualSubarray(List<Integer> nums, int k) {
        // 满足最多k+1个值不同 最长长度
        int maxLen = 0;

        // 分组计算
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            map.put(num, map.getOrDefault(num, new ArrayList<>()));
            map.get(num).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> indexList = entry.getValue();
            if (indexList.size() == 1) {
                maxLen = Math.max(maxLen, 1);
                continue;
            }

            int left = 0;
            int right = 1;

            while (right < indexList.size()) {
                while (indexList.get(right) - indexList.get(left) - 1 - (right - left - 1) > k) {
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);

                right++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new P2831().longestEqualSubarray(Arrays.asList(1,3,2,3,1,3), 3));
        System.out.println(new P2831().longestEqualSubarray(Arrays.asList(1,1,2,2,1,1), 2));
    }
}
