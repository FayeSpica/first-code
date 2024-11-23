package org.faye.c415;

public class P1 {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int index = 0;

        int[] counter = new int[101];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            if (counter[nums[i]] == 2) {
                res[index] = nums[i];
                index++;
            }
        }
        return res;
    }
}
