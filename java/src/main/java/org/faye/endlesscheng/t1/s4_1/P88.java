package org.faye.endlesscheng.t1.s4_1;

public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int n1 = m - 1;
        int n2 = n - 1;
        int c = m + n - 1;

        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] >= nums2[n2]) {
                nums1[c--] = nums1[n1--];
            } else {
                nums1[c--] = nums2[n2--];
            }
        }
        while (n1 >= 0) {
            nums1[c--] = nums1[n1--];
        }
        while (n2 >= 0) {
            nums1[c--] = nums2[n2--];
        }
    }
}
