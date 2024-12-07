package org.faye.bc.bc145;

import java.util.PriorityQueue;

public class P3 {
    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean oneStep(int a, int b) {
        char[] aa = String.valueOf(a).toCharArray();
        char[] bb = String.valueOf(b).toCharArray();
        if (a == b) {
            return false;
        }
        if (aa.length != bb.length) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < aa.length; i++) {
            int d = aa[i] - bb[i];
            count += Math.abs(d);
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    // 转换为图的最短路径
    public int minOperations(int n, int m) {
        boolean[] prime = new boolean[10001];

        for (int i = 2; i <= 10000; i++) {
            prime[i] = isPrime(i);
        }

        // a to b cost
        int[][]cost  = new int[10001][10001];

        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 10000; j++) {
                if (prime[i] || prime[j]) {
                    cost[i][j] = -1;
                } else {
                    // 判断一步能到j
                    if (oneStep(i, j)) {
                        cost[i][j] = j;
                    }
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P3().minOperations(10, 12));
    }
}
