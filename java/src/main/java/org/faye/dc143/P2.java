package org.faye.dc143;

import java.util.Arrays;

public class P2 {
    // 选择numOperations个元素进行 加减 使得所有元素相等
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        // 前缀和
        int[] counter = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]] += 1;
        }

        int[] sumCounter = new int[100001];
        sumCounter[0] = counter[0];
        for (int i = 1; i < counter.length; i++) {
            sumCounter[i] = sumCounter[i - 1] + counter[i];
        }

        int start = nums[0];
        int end = nums[nums.length - 1];

        int res = 0;

        for (int i = start; i <= end; i++) {
            // 选择i作为hit时，能有多少元素
            int min = i - k;
            int max = i + k;
            if (min < 0) {
                min = 0;
            }
            if (max > 100000) {
                max = 100000;
            }

            int noNeedOpCount = counter[i];
            int totalLimit = noNeedOpCount + numOperations;

            int s = sumCounter[max] - sumCounter[min] + counter[min];
            if (s > totalLimit) {
                s = totalLimit;
            }
            if (s > res) {
                res = s;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P2().maxFrequency(new int[]{1, 2, 4, 5}, 2, 4));;
    }
}
