package org.faye.c.c426;

import java.util.Arrays;

public class P2 {
    public int getLargestOutlier(int[] nums) {
        // 所有n-2的数值和
        int sum = 0;
        int[] counter = new int[2001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            counter[nums[i] + 1000]++;
        }

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            int abnormal = nums[i];
            int cSumDouble = sum - abnormal;
            if (cSumDouble % 2 != 0) {
                continue;
            }
            int cSum = cSumDouble / 2;
            if (cSum < -1000 || cSum > 1000) {
                continue;
            }

            if (cSum == abnormal) {
                if (counter[cSum + 1000] >= 2) {
                    // hit max
                    return abnormal;
                }
            } else {
                if (counter[cSum + 1000] > 0) {
                    // hit max
                    return abnormal;
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
//        System.out.println(new P2().getLargestOutlier(new int[]{-2,-1,-3,-6,4}));
//        System.out.println(new P2().getLargestOutlier(new int[]{1,1,1,1,1,5,5}));
        System.out.println(new P2().getLargestOutlier(new int[]{966,104,-116,-999,-97,-408,-266,-116}));
    }
}
