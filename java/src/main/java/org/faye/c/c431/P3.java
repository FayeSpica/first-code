package org.faye.c.c431;

import java.util.Arrays;
import java.util.Comparator;

public class P3 {
    public long maximumCoins(int[][] coins, int k) {
        Arrays.sort(coins, Comparator.comparingInt(o -> o[0]));
        long maxSum = 0;
        int range = 0;
        long prevSum = 0;
        int left = coins.length - 1;
        int right = coins.length - 1;
        while (left >= 0 && right >= 0) {
            prevSum += (long) coins[left][2] * (coins[left][1] - coins[left][0] + 1);
            range = coins[right][1] - coins[left][0] + 1;
            if (range >= k) {
                // counting from left
                long overFlowLen = (range - k + 1);
                long overflow = overFlowLen * (coins[left][1] - coins[left][0] + 1);
                long sum = prevSum - overflow;
                if (sum > maxSum) {
                    maxSum = sum;
                }
                prevSum -= (long) coins[right][2] * (coins[right][1] - coins[right][0] + 1);
                right--;
            } else {
                left--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new P3().maximumCoins(new int[][]{{8, 10, 1}, {1, 3, 2}, {5, 6, 4}}, 4));
    }
}
