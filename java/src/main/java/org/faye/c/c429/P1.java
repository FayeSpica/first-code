package org.faye.c.c429;

public class P1 {
    public int minimumOperations(int[] nums) {
        int right = nums.length - 1;
        int[] counter = new int[101];
        for (; right >= 0 ; right--) {
            if (counter[nums[right]] == 0) {
                counter[nums[right]]++;
            } else {
                break;
            }
        }
        right++;
        return right / 3 + (right % 3 == 0 ? 0 : 1);
    }
}
