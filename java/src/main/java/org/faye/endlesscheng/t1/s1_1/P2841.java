package org.faye.endlesscheng.t1.s1_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2841 {
    // todo: slow 40%
    public long maxSum(List<Integer> nums, int m, int k) {
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int enterNum = nums.get(i);
            sum += enterNum;
            counterMap.put(enterNum, counterMap.getOrDefault(enterNum, 0) + 1);

            if (i < k - 1) {
                continue;
            }

            // update
            if (counterMap.size() >= m) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }

            int exitNum = nums.get(i - k + 1);
            sum -= exitNum;

            counterMap.put(exitNum, counterMap.get(exitNum) - 1);
            int t = counterMap.get(exitNum);
            if (t == 0) {
                counterMap.remove(exitNum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        System.out.println(new P2841().maxSum(Arrays.asList(2,6,7,3,1,7), 3, 4));
        System.out.println(new P2841().maxSum(Arrays.asList(5,4,8,4,8,10,10), 3, 3));
    }
}
