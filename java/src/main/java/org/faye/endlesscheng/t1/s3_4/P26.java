package org.faye.endlesscheng.t1.s3_4;

public class P26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            while (fast < nums.length && nums[slow] == nums[fast]) {
                fast++;
            }
            slow++;
            if (fast >= nums.length) {
                break;
            }
            nums[slow] = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new P26().removeDuplicates(new int[]{1,1,2}));
    }
}
