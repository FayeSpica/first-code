package org.faye.endlesscheng.t1;

import java.util.HashSet;
import java.util.Set;

public class P1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] counter = new int[100001];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            set.add(nums[i]);
            if (i < k - 1) {
                continue;
            }

            ans[i - k + 1] = set.size();

            counter[nums[i - k + 1]]--;
            if (counter[nums[i - k + 1]] == 0) {
                set.remove(nums[i - k + 1]);
            }
        }

        return ans;
    }
}
