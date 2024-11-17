package org.faye.c424;

import java.util.Arrays;

public class P1 {
    public int countValidSelections(int[] nums) {
        int ans = 0;
        int[] directions = new int[]{-1, 1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < directions.length; j++) {
                if (nums[i] != 0) {
                    continue;
                }
                int[] temp = Arrays.copyOf(nums, nums.length);
                simulate(temp, i, directions[j]);
                int count = 0;
                for (int k = 0; k < temp.length; k++) {
                    if (temp[k] == 0) {
                        count++;
                    }
                }
                if (count == nums.length) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public void simulate(int[] nums, int curr, int direction) {
//        System.out.println(Arrays.toString(nums) + " | " + curr + " | " + direction);
        if (!(curr >= 0 && curr < nums.length)) {
            return;
        }
        if (nums[curr] == 0) {
            simulate(nums, curr + direction, direction);
        } else if (nums[curr] > 0) {
            nums[curr]--;
            direction *= -1;
            simulate(nums, curr + direction, direction);
        }
    }

    public static void main(String[] args) {
        System.out.println(new P1().countValidSelections(new int[]{1, 2, 0, 3}));
    }
}
