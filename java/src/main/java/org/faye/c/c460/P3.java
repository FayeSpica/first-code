package org.faye.c.c460;

public class P3 {
    public int minJumps(int[] nums) {
        // 到第i格的最小步数
        // nums[i] = Math.min(nums[i-1], nums[i- prime]...)
        boolean[] prime = new boolean[nums.length];
        for (int i = 3; i < nums.length; i+=2) {
            prime[i] = isPrime(i);
        }
        return 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
    }
}
