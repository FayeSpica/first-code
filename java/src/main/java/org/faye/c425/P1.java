package org.faye.c425;

import java.util.Arrays;
import java.util.List;

public class P1 {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for (int len = l; len <= r; len++) {
            for (int i = 0; i < nums.size(); i++) {
                int rr = i + len;
                if (rr > nums.size()) {
                    continue;
                }
                // sum [i, i + len]
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    sum += nums.get(j);
                }
//                System.out.println("len:" + len + " sum[" + i + "," + (i + len - 1) + "]=" + sum);
                if (sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public int minimumSumSubarray1(List<Integer> nums, int l, int r) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        sum += nums.get(left);

//        while (true) {
//            int len = right - left + 1;
//            if (len >= l && len <= r) {
//                if (sum > 0) {
//                    if (sum < minSum) {
//                        minSum = sum;
//                    }
//                } else
//            } else if (len < l) {
//                right++;
//            } else {
//                left++;
//            }
//        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        System.out.println(new P1().minimumSumSubarray(Arrays.asList(3, -2, 1, 4), 2, 3));
        System.out.println(new P1().minimumSumSubarray(Arrays.asList(-2, 2, -3, 1), 2, 3));
        System.out.println(new P1().minimumSumSubarray(Arrays.asList(1, 2, 3, 4), 2, 4));

    }
}
