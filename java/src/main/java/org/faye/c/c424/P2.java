package org.faye.c.c424;

public class P2 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 范围- 恰好为0
        // 对每个nums[i] 判断是否至少有nums[i]个queries包含i
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            diff[queries[i][0]]--;
            diff[queries[i][1] + 1]++;
        }

        int[] newNums = new int[nums.length];
        newNums[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            newNums[i] = newNums[i - 1] + diff[i];
        }
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P2().isZeroArray(new int[]{1, 0, 1}, new int[][]{
                {0, 2},
        }));
    }
}
