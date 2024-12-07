package org.faye.endlesscheng.t1.s1_1;

import java.util.Arrays;

public class P2653 {

    // todo: slow 10%
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + 50;
        }

        int[] counter = new int[101];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            if (i < k - 1) {
                continue;
            }

            // update
            int c = 0;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] > 0) {
                    c += counter[j];
                    if (c >= x) {
                        res[i - k + 1] = Math.min(j - 50, 0);
                        break;
                    }
                }
            }

            counter[nums[i - k + 1]]--;
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new P2653().getSubarrayBeauty(new int[] {1,-1,-3,-2,3}, 3, 2)));
        System.out.println(Arrays.toString(new P2653().getSubarrayBeauty(new int[] {-3,1,2,-3,0,-3}, 2, 1)));
    }
}
