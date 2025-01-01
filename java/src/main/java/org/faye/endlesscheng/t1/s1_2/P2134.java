package org.faye.endlesscheng.t1.s1_2;

public class P2134 {
    public int minSwaps(int[] nums) {
        int maxSum = 0;
        // 定长的最少0
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                k++;
            }
        }

        if (k == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length * 2; i++) {
            sum += nums[i % nums.length];
            if (i < k - 1) {
                continue;
            } else {
                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum -= nums[(i - k + 1) % nums.length];
            }
        }

        return k - maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new P2134().minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println(new P2134().minSwaps(new int[]{1,1,0,0,1}));
    }
}
