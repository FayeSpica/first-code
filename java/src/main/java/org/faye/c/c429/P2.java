package org.faye.c.c429;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P2 {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        // [nums[i]-k, nums[i]+k]
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (k == 0 || nums.length == 1) {
            return map.size();
        }

        int min = nums[0] - k;
        int max = nums[nums.length - 1] + k;

        int left = 0;
        int right = nums.length - 1;

        HashSet<Integer> set = new HashSet<>();

        // 首尾可以直接-k, +k 加完之后 min,max范围缩小
        while (left < right) {
            // 满足>=min的最小数
            if (min >= nums[left] - k && min <= nums[left] + k) {
                set.add(min);
                min = min + 1;
            } else {
                set.add(nums[left] - k);
                min = nums[left] - k + 1;
            }
            // 满足<=max的最大数
            // 二分搜索
            if (max >= nums[right] -k && nums[right] + k <= max) {
                set.add(max);
                max = max - 1;
            } else {
                // max < nums[right] + k
                set.add(max);
                max = max - 1;
            }
            left++;
            right--;
        }
        int c = 0;
        if (left == right) {
            // 判断在不在区间内
            if (hasIntersection(nums[left] - k, nums[left] + k, min, max)) {
                c++;
            }
        }

        return set.size() + c;
    }

    public static boolean hasIntersection(int start1, int end1, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return false;
        }

        return !(end1 < start2 || end2 < start1);
    }

    public static void main(String[] args) {
//        System.out.println(new P2().maxDistinctElements(new int[]{4, 4, 4, 4}, 1));
//        System.out.println(new P2().maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2));
//        System.out.println(new P2().maxDistinctElements(new int[]{5, 5, 7}, 2));
//        System.out.println(new P2().maxDistinctElements(new int[]{9,10,9,9,10,10,9,9,10}, 1));
    }
}
