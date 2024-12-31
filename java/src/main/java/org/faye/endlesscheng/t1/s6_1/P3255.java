package org.faye.endlesscheng.t1.s6_1;

import java.util.Arrays;

public class P3255 {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];

        if (k == 1) {
            System.arraycopy(nums, 0, result, 0, nums.length);
            return result;
        }

        Arrays.fill(result, -1);

        int left = 0;
        int right = 1;
        int prev = nums[left];

        int len = 0;
        
        while (right < nums.length) {
            if (prev + 1 == nums[right]) {
                len = right + 1 - left;
                if (len < k) {
                    prev++;
                    right++;
                } else if (len == k) {
                    result[left] = nums[right];
                    left++;
                    prev++;
                    right++;
                }
            } else {
                left = right;
                prev = nums[left];
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P3255().resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
}
