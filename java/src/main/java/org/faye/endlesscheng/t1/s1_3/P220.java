package org.faye.endlesscheng.t1.s1_3;

import java.util.Arrays;

public class P220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);

        // 1 1 2 3
        // 1 2 3 1

        // 1 5 9 1 5 9
        // 1 1 5 5 9 9

        for (int k = 1; k <= indexDiff; k++) {
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    continue;
                } else {
                    int diff = Math.abs(nums[i] - nums[i - k]);
                    if (diff <= valueDiff) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }
}
