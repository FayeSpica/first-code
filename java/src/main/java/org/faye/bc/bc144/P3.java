package org.faye.bc.bc144;

public class P3 {
    public int maxRemoval(int[] nums, int[][] queries) {
        // 删除最多条目
        // queries 最小集

        // 谁不可少？

        // 1. 重复的可删除
        // 2. 重叠的可删除
        // 3. 范围只有0的可删除
        // 4. 剩下的有余可删除 [0, 2] [2, 4] [1, 3]
        // [2, 0, 0, 0, 0, 0, 2] [[0,0], [0,0], [6, 6], [6, 6], [1, 1], [1, 5], [2, 6]]

        int[] d = new int[nums.length + 1];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            d[i] = nums[i] - nums[i - 1];
        }

        // 2 -2 2
        // 0 -2 4
        // 4 -2 0
        // 0

        for (int i = 0; i < queries.length; i++) {
            d[queries[i][0]]--;
            d[queries[i][1] + 1]++;
        }

        int[] newNums = new int[nums.length];
        newNums[0] = d[0];
        for (int i = 1; i < nums.length; i++) {
            newNums[i] = newNums[i - 1] + d[i];
            if (newNums[i] > 0) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P3().maxRemoval(new int[]{2, 0, 2}, new int[][]{{0,2},{0,2},{1,1}}));
    }
}
