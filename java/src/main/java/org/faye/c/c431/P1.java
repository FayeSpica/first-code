package org.faye.c.c431;

public class P1 {

    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public int maxLength(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // [i, j]
                long prod = (long) nums[i] * nums[i + 1];
                int gcd = gcd(nums[i], nums[i + 1]);
                int lcm = lcm(nums[i], nums[i + 1]);
                if (prod == (long) lcm * gcd) {
                    maxLen = Math.max(maxLen, 2);
                }
                for (int k = i + 2; k <= j; j++) {
                    prod *= nums[k];
                    gcd = gcd(gcd, nums[k]);
                    lcm = lcm(lcm, nums[k]);
                }
                if (prod == (long) lcm * gcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
