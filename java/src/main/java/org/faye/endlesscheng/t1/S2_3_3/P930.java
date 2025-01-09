package org.faye.endlesscheng.t1.S2_3_3;

public class P930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumGt(nums, goal) - numSubarraysWithSumGt(nums, goal + 1);
    }

    public int numSubarraysWithSumGt(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 1;
        sum += nums[left];
        if (sum >= goal) {
            count++;
        }
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= goal && left <= right) {
                count+=nums.length - right;
                sum -= nums[left++];
            }
            right++;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P930().numSubarraysWithSum(new int[]{0,0,0,0,0}, 0)    );
    }
}
