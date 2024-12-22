package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2824 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        // -1 1 1 2 3
        int left = 0;
        int right = nums.size() - 1;

        int count = 0;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // hit
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P2824().countPairs(Arrays.asList(-1,1,2,3,1), 2));
    }
}
