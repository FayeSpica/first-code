package org.faye.c424;

import java.util.Arrays;
import java.util.Comparator;

public class P2 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 范围- 恰好为0
        // 对每个nums[i] 判断是否至少有nums[i]个queries包含i

        Arrays.sort(queries, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return 0;
                } else if (a[1] > b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return -1;
            }
        });

        // binary search
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];

//            for (int j = 0; j < queries.length; j++) {
//                if (i >= queries[j][0] && i <= queries[j][1]) {
//                    sum--;
//                }
//            }
            int leftIndex = binarySearch(queries, 0, queries.length - 1, i, 0);
            int rightIndex = binarySearch(queries, 0, queries.length - 1, i, 1);

            if (leftIndex >= 0 && rightIndex >= 0 && leftIndex <= rightIndex) {
                sum -= rightIndex - leftIndex + 1;
            }
            if (sum > 0) {
                return false;
            }
        }
        return true;
    }

    public int binarySearch(int[][] queries, int fromIndex, int toIndex, int target, int index) {
        int left = fromIndex;
        int right = toIndex;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            int midVal = queries[mid][0];
            int cmp = midVal - target;

            if (cmp < 0)
                left = mid + 1;
            else if (cmp > 0)
                right = mid - 1;
            else
                return mid; // key found
        }
        return (left + 1);  // key not found.
    }

    public static void main(String[] args) {
        System.out.println(new P2().isZeroArray(new int[]{3}, new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
        }));
    }
}
