package org.faye.endlesscheng.t1.s2_1;

public class P1695 {
    public int maximumUniqueSubarray(int[] nums) {
        // 找出最大不同子数组
        int maxSum = nums[0];

        int[] counter = new int[10001];

        int left = 0;
        int right = 1;
        counter[nums[left]]++;
        int sum = nums[left];
        while (right < nums.length) {

            counter[nums[right]]++;
            sum += nums[right];

            while (counter[nums[right]] > 1) {
                counter[nums[left]]--;
                sum -= nums[left];
                left++;
            }

            if (sum > maxSum) {
                maxSum = sum;
            }

            right++;
        }

        return maxSum;
    }
}
