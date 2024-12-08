package org.faye.c.c427;

public class P1 {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = nums[i];
            } else if (nums[i] > 0) {
                int nextIndex = (i + nums[i]) % nums.length;
                result[i] = nums[nextIndex];
            } else {
                int nextIndex = (i + nums[i]) % nums.length;
                while (nextIndex < 0) {
                    nextIndex += nums.length;
                }
                result[i] = nums[nextIndex];
            }
        }

        return result;
    }
}
