package org.faye.endlesscheng.t1.s6_1;

public class P845 {
    public int longestMountain(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int mid = left;
        while (left < arr.length) {
            do {
                mid++;
            } while (mid < arr.length && arr[mid - 1] < arr[mid]);
            mid--;
            if (mid == left) {
                left = mid + 1;
                mid++;
                continue;
            }
            // mid is top
            int right = mid;
            do {
                right++;
            } while (right < arr.length && arr[right - 1] > arr[right]);
            right--;
            if (right > mid) {
                int len = right - left + 1;
                res = Math.max(res, len);
            }
            left = right;
            mid = left;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P845().longestMountain(new int[] { 0,2,0,2,1,2,3,4,4,1 }));
    }
}
