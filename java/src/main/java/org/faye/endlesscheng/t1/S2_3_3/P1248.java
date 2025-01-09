package org.faye.endlesscheng.t1.S2_3_3;

import java.util.Arrays;

public class P1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysGt(nums, k) - numberOfSubarraysGt(nums, k + 1);
    }

    public int numberOfSubarraysGt(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 1;
        sum += nums[left] % 2 == 0 ? 0 : 1;
        if (sum >= k) {
            count++;
        }
        while (right < nums.length) {
            sum += nums[right] % 2 == 0 ? 0 : 1;
            while (sum >= k && left <= right) {
                count += nums.length - right;
                sum -= nums[left] % 2 == 0 ? 0 : 1;
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P1248().numberOfSubarrays(new int[] { 1, 1, 1, 1, 1 }, 1));
    }
}
