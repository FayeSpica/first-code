package org.faye.c.c427;

public class P3 {

    public long maxSubarraySum(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        long maxSum = Long.MIN_VALUE;

        // 以i为起点长度为
        // [start, start + len - 1]
        // preFixSum差最大的组
        long[] dp = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Long.MIN_VALUE;
        }
//        int[] len = new int[nums.length];
//        len[0] = 1;
//        dp[0] = k == 1 ? nums[0] : 0;
        // dp[i] 以i结尾且长度%k的最大子数组和
        // len[i] 以i结尾且长度%k的最大子数组具体长度
        for (int i = k - 1; i < nums.length ; i++) {
            if (i == k - 1) {
                long newLenSum = prefixSum[i + 1] - prefixSum[i - k + 1];
                dp[i] = newLenSum;
                maxSum = Math.max(maxSum, dp[i]);
                continue;
            }
            long newLenSum = (dp[i - k] == Long.MIN_VALUE ? 0 : Math.max(0, dp[i - k])) +  prefixSum[i + 1] - prefixSum[i - k + 1];
            dp[i] = newLenSum;
            maxSum = Math.max(maxSum, dp[i]);
        }

//        // 遍历所有长度
//        for (int i = nums.length/k; i > 0; i--) {
//            int len = i * k;
//            // 找起点
//            // N方
//            for (int start = 0; start + len - 1 < nums.length; start++) {
//                int v = prefixSum[start + len] - prefixSum[start];
//                if (v > maxSum) {
//                    maxSum = v;
//                }
//            }
//        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }

    public static void main(String[] args) {
        int[] n = new int[200000];
//        System.out.println(new P3().maxSubarraySum(new int[]{1, 2}, 1));
//        System.out.println(new P3().maxSubarraySum(new int[]{-5,1,2,-3,4}, 2));
//        System.out.println(new P3().maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4));
//        System.out.println(new P3().maxSubarraySum(n, 1));
//        System.out.println(new P3().maxSubarraySum(new int[]{-10, -1}, 1));
        System.out.println(new P3().maxSubarraySum(new int[]{3, -11, 8}, 1));
    }
}
