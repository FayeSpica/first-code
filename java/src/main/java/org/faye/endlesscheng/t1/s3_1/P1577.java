package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P1577 {
    // todo slow 42%
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            int left = 0;
            int right = nums2.length - 1;

            while (left < right) {
                if (nums2[left] * (long)nums2[right] == (long) nums1[i] *nums1[i]) {
                    if (nums2[left] == nums2[right]) {
                        count+=(right-left + 1) * (right-left) / 2;
                        right = left;
                    } else {
                        int newLeft = left;
                        int newRight = right;
                        int cLeft = 0;
                        int cRight = 0;
                        while (nums2[newLeft] == nums2[left]) {
                            cLeft++;
                            newLeft++;
                        }
                        while (nums2[newRight] == nums2[right]) {
                            cRight++;
                            newRight--;
                        }
                        count+=cLeft*cRight;
                        left=newLeft;
                        right=newRight;
                    }
                } else if (nums2[left] * (long)nums2[right] > (long) nums1[i] *nums1[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int left = 0;
            int right = nums1.length - 1;

            while (left < right) {
                if (nums1[left] * (long)nums1[right] == (long) nums2[i] *nums2[i]) {
                    if (nums1[left] == nums1[right]) {
                        count+=(right-left + 1) * (right-left) / 2;
                        right = left;
                    } else {
                        int newLeft = left;
                        int newRight = right;
                        int cLeft = 0;
                        int cRight = 0;
                        while (nums1[newLeft] == nums1[left]) {
                            cLeft++;
                            newLeft++;
                        }
                        while (nums1[newRight] == nums1[right]) {
                            cRight++;
                            newRight--;
                        }
                        count+=cLeft*cRight;
                        left=newLeft;
                        right=newRight;
                    }
                } else if (nums1[left] * (long)nums1[right] > (long) nums2[i] *nums2[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P1577().numTriplets(new int[] { 7, 4 }, new int[] { 5, 2, 8, 9 }));
        System.out.println(new P1577().numTriplets(new int[] { 1, 1 }, new int[] { 1, 1, 1 }));
    }
}
