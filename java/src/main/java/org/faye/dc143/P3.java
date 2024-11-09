package org.faye.dc143;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class P3 {
    // 选择numOperations个元素进行 加减 使得所有元素相等
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);

        // 前缀和
        HashMap<Integer, Integer> counterMap = new HashMap<>(100001);
        counterMap.put(-1, 0);
        for (int i = 0; i < nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
        }

        HashSet<Integer> visitedNum = new HashSet<>(100001);

        HashMap<Integer, Integer> sumCounterMap = new HashMap<>(100001);
        sumCounterMap.put(-1, 0);
        sumCounterMap.put(nums[0], counterMap.get(nums[0]));
        visitedNum.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (visitedNum.contains(nums[i])) {
                continue;
            }
            visitedNum.add(nums[i]);
            sumCounterMap.put(nums[i], counterMap.get(nums[i]) + sumCounterMap.get(nums[i - 1]));
        }

        int start = nums[0];
        int end = nums[nums.length - 1];

        int res = 1;

        for (int i = start; i <= end; i++) {
            // 选择i作为hit时，能有多少元素
            int min = i - k;
            int max = i + k;
            if (min < 0) {
                min = 0;
            }
            if (max > 1000000000) {
                max = 1000000000;
            }

            int noNeedOpCount = counterMap.getOrDefault(i, 0);
            int totalLimit = noNeedOpCount + numOperations;

            int s = 0;
            // 从就近的sumCounterMap中获取s
            // 从nums[i]中找到离max最近最大的
            // 从nums[j]中找到离min最近最小的

            // 二分查找
            int trueMinIndex = firstHitMaxIndex(nums, min);
            int trueMaxIndex = firstHitMinIndex(nums, max);

            int trueMin;
            if (trueMinIndex == -1) {
                trueMin = -1;
            } else {
                trueMin = nums[trueMinIndex];
            }

            int trueMax;
            if (trueMaxIndex == -1) {
                trueMax = -1;
            } else {
                trueMax = nums[trueMaxIndex];
            }

            if (counterMap.containsKey(min)) {
                trueMin = min;
            }

            if (counterMap.containsKey(max)) {
                trueMax = max;
            }

            s = sumCounterMap.getOrDefault(trueMax, 0) - sumCounterMap.getOrDefault(trueMin, 0) + counterMap.getOrDefault(trueMin, 0);

            if (s > totalLimit) {
                s = totalLimit;
            }
            if (s > res) {
                res = s;
            }
        }

        return res;
    }

    int firstHitMinIndex(int[] nums, int d) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < d) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    int firstHitMaxIndex(int[] nums, int d) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < d) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new P3().maxFrequency(new int[]{1,2,4,5}, 2, 4));
//        System.out.println(new P3().maxFrequency(new int[]{5,11,20,20}, 5, 1));
//        System.out.println(new P3().maxFrequency(new int[]{1, 4, 5}, 1, 2));
//        System.out.println(new P3().maxFrequency(new int[]{2435,50762,78597,37204,44172,92277,4310,87937,8634,34007,53730,53153,29731,46259,96889,52440,7907,36766,69786,39340}, 7979, 2));;
//
        System.out.println(new P3().maxFrequency(new int[]{847619,873528,337344,25883,600690,210327,603309,234593,386477,538043,357456,148423,103016,461519,162087,266326,165685,745240,170243,440225,58633,27372,343527,240377,394130,894608,810751,391403,993210,747014,276679,449753,78878,734045,700109,414817,317676,322199,122255,731245,532259,50202,294626,351553,153453,375406,972334,952478,524954,404653,276484,293279,332178,546200,225740,11937,482038,335514,719703,479443,148204,591130,894801,539822,812422,387508,109101,711134,720820,238282,415196,149865,421822,321404,450575,343315,733736,465306,587916,706164,977282,372227,311465,1012,731700,831421,554281,554869,840331,876473,84730,366783,874592,790595,36555,619229,888219,239036,962438,983934}, 248434000, 21));;
    }
}
