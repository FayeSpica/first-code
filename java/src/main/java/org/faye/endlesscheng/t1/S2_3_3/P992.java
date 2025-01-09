package org.faye.endlesscheng.t1.S2_3_3;

import java.util.HashMap;

public class P992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctGt(nums, k) - subarraysWithKDistinctGt(nums, k + 1);
    }

    public int subarraysWithKDistinctGt(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[left], map.getOrDefault(nums[left], 0) + 1 );
        if (map.size() >= k) {
            count++;
        }

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() >= k && left <= right) {
                count += nums.length - right;
                int v = map.get(nums[left]) - 1;
                if (v == 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], v);
                }
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P992().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
}
