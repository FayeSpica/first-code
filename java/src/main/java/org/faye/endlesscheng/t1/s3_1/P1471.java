package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P1471 {
    // todo slow
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int m = left + (right - left) / 2;

        int[] result = new int[k];

        // 最强肯定在左右端点产生
        // left++ right--
        for (int i = 0; i < k; i++) {
            int leftV = Math.abs(arr[left] - arr[m]);
            int rightV = Math.abs(arr[right] - arr[m]);
            if (leftV == rightV) {
                // choose right
                result[i] = arr[right];
                right--;
            } else if (leftV > rightV) {
                result[i] = arr[left];
                left++;
            } else {
                result[i] = arr[right];
                right--;
            }
        }

        return result;
    }
}
