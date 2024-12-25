package org.faye.endlesscheng.t1.s4_1;

public class P2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = 0;

        int n1 = 0;
        int n2 = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1][0] == nums2[n2][0]) {
                n++;
                n1++;
                n2++;
            } else if (nums1[n1][0] > nums2[n2][0]) {
                n++;
                n2++;
            } else {
                n++;
                n1++;
            }
        }

        while (n1 < nums1.length) {
            n++;
            n1++;
        }

        while (n2 < nums2.length) {
            n++;
            n2++;
        }

        int[][] result = new int[n][2];

        int i = 0;
        n1 = 0;
        n2 = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1][0] == nums2[n2][0]) {
                result[i] = new int[]{nums1[n1][0], nums1[n1][1] + nums2[n2][1]};
                n1++;
                n2++;
                i++;
            } else if (nums1[n1][0] > nums2[n2][0]) {
                result[i] = new int[]{nums2[n2][0], nums2[n2][1]};
                n2++;
                i++;
            } else {
                result[i] = new int[]{nums1[n1][0], nums1[n1][1]};
                n1++;
                i++;
            }
        }

        while (n1 < nums1.length) {
            result[i] = new int[]{nums1[n1][0], nums1[n1][1]};
            n1++;
            i++;
        }

        while (n2 < nums2.length) {
            result[i] = new int[]{nums2[n2][0], nums2[n2][1]};
            n2++;
            i++;
        }

        return result;
    }
}
