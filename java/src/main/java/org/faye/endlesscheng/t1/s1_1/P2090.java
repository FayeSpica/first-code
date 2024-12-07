package org.faye.endlesscheng.t1.s1_1;

public class P2090 {
    public int[] getAverages(int[] nums, int k) {

        int[] ans = new int[nums.length];

        long sum = 0;

        int kk = 2 * k + 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < kk - 1) {
                continue;
            }
            int j = i - k;
            ans[j] = (int) (sum / kk);

            sum -= nums[i - kk + 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100000;
        }
        System.out.println(new P2090().getAverages(nums, 40000));
    }
}
