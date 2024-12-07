package org.faye.endlesscheng.t1.s1_1;

import java.util.HashMap;
import java.util.Map;

public class P2461 {

    // todo: slow 20%
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
            if (i < k - 1) {
                continue;
            }

            // update
            if (counterMap.size() == k) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

            sum -= nums[i - k + 1];
            counterMap.put(nums[i - k + 1], counterMap.get(nums[i - k + 1]) - 1);
            if (counterMap.get(nums[i - k + 1]) == 0) {
                counterMap.remove(nums[i - k + 1]);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new P2461().maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
