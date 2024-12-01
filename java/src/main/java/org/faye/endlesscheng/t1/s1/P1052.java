package org.faye.endlesscheng.t1.s1;

public class P1052 {

    // todo: 无需defaultSum fullSum数组
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        long[] defaultSum = new long[customers.length];
        long[] fullSum = new long[customers.length];
        defaultSum[0] = (long) customers[0] * r(grumpy[0]);
        fullSum[0] = customers[0];
        for (int i = 1; i < customers.length; i++) {
            defaultSum[i] = defaultSum[i - 1] + (long) customers[i] * r(grumpy[i]);
            fullSum[i] = fullSum[i - 1] + customers[i];
        }

        for (int i = 0; i < customers.length; i++) {
            if (i < minutes - 1) {
                continue;
            }

            // update
            // fullSum [i - minutes + 1, i]
            // defaultSum[0, i - minutes]
            // defaultSum[i + 1, customers.length - 1]
            long sum = fullSum[i] - (i - minutes < 0 ? 0 : fullSum[i - minutes]);
            sum += i - minutes < 0 ? 0 : defaultSum[i - minutes];
            sum += defaultSum[customers.length - 1] - defaultSum[i];

            if (sum > ans) {
                ans = (int) sum;
            }
        }

        return ans;
    }

    public int r(int c) {
        if (c == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P1052().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(new P1052().maxSatisfied(new int[]{3}, new int[]{1}, 1));
    }
}
