package org.faye.c424;

public class P3 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int k = -1;
        int left = 0;
        int right = queries.length - 1;
        if (isZeroArray(nums, queries, -1)) {
            k = 0;
            return k;
        }
        if (isZeroArray(nums, queries, right)) {
            k = right + 1;
        }
        if (isZeroArray(nums, queries, left)) {
            k = left + 1;
            return k;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println("mid=" + mid);
            if (isZeroArray(nums, queries, mid)) {
                // System.out.println("hit mid=" + mid);
                if (mid + 1 < k) {
                    k = mid + 1;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // System.out.println(k);
        return k;
    }

    public boolean isZeroArray(int[] nums, int[][] queries, int k) {
        // 范围- 恰好为0
        // 对每个nums[i] 判断是否至少有nums[i]个queries包含i
        int[] diff = new int[nums.length + 1];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i <= k; i++) {
            diff[queries[i][0]]-=queries[i][2];
            diff[queries[i][1] + 1]+=queries[i][2];
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
}
