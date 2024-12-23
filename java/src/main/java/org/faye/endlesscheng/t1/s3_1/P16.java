package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int minSum= -1;
        // -4 -1 1 2
        for (int a = 0; a < nums.length; a++) {
            int left = a + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentDistance = Math.abs(nums[a] + nums[left] + nums[right] - target);
                if (currentDistance < distance) {
                    distance = currentDistance;
                    minSum = nums[a] + nums[left] + nums[right];
                }
                if (nums[a] + nums[left] + nums[right] - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(new P16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
