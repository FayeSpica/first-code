package org.faye.c.c423;

import java.util.Arrays;
import java.util.List;

public class P2 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int minK = 1;

        // dp 以index开始的 递增子数组的长度
        int[] dp = new int[200001];

        // 倒着填
        for (int i = nums.size() - 1; i >= 0; i--) {
            dp[i] = 1;
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (i == 0) {
                continue;
            }

            if (nums.get(i) > nums.get(i - 1)) {
                dp[i - 1] = dp[i] + 1;
            }
        }

        // 寻找一个 最大的j - i 使得j - i <= dp[i] && j - i <= dp[j]
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                continue;
            }
            int left = 1;
            int right = dp[i];

            if (i + right < dp.length && dp[i + right] >= right) {
                if (right > minK) {
                    minK = right;
                }
                continue;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;

                int j = i + mid;

                if (j < dp.length && dp[j] >= mid) {
                    left = mid + 1;
                    if (mid > minK) {
                        minK = mid;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }
        return minK;
    }

    public static void main(String[] args) {
        System.out.println(new P2().maxIncreasingSubarrays(Arrays.asList(2,5,7,8,9,2,3,4,3,1)));;
        System.out.println(new P2().maxIncreasingSubarrays(Arrays.asList(-15,9)));;
    }
}
