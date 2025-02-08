package org.faye.c.c433;

public class P1 {
    public int subarraySum(int[] nums) {
        int[] sums = new int[nums.length + 1];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int sum = 0;
        for (int i = 0; i < sums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            sum += sums[i] - (start - 1 >= 0 ? sums[start - 1] : 0);
        }
        return sum;
    }
}
