package org.faye.c414;

import java.util.Arrays;
import java.util.List;

public class P3 {
    public long findMaximumScore(List<Integer> nums) {
        long[] dp = new long[nums.size()];
        dp[0] = 0; //
        // dp[nums.size()-1]??

//        dp[1] = (1 - 0) * nums.get(0);
//        dp[2] = Math.max((2 - 0) * nums.get(0), dp[1] + (1 - 0) * nums.get(1));
//        dp[3] = Math.max((3 - 0) * nums.get(0), dp[2] + (3 - 1) * nums.get(1), dp[1] + (3 - 2) * nums.get(2));
//        dp[4] = Math.max((4 - 0) * nums.get(0), dp[3] + (4 - 1) * nums.get(1), dp[2] + (4 - 2) * nums.get(2), dp[1] + (4 - 3) * nums.get(1);

        // dp[2] = (2 - 0) * nums.get(0) | (1 - 0) * nums.get(0) + (1 - 0) * nums.get(1))
        // dp[3] = (3 - 0) * nums.get(0) | (2 - 0) * nums.get(0) |  (1 - 0) * nums.get(0) + (1 - 0) * nums.get(1))

        for (int i = 1; i < nums.size(); i++) {
            long max = 0;
            for (int j = 0; j < i; j++) {
                long d = dp[j] + (long)(i - j) * nums.get(j);
                if (d > max) {
                    max = d;
                }
            }
            dp[i] = max;
        }

        return dp[nums.size()-1];
    }

    public static void main(String[] args) {
        System.out.println(new P3().findMaximumScore(Arrays.asList(1,3,1,5)));
        System.out.println(new P3().findMaximumScore(Arrays.asList(4,3,1,3,2)));
    }
}
