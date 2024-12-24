package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P11 {
    public int maxArea(int[] height) {
        // 1 8 6 2 5 4 8 3 7
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            // 短板效应
            int area = w * h;
            if (area > maxArea) {
                maxArea = area;
            }

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
