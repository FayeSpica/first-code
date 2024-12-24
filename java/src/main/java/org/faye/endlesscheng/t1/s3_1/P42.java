package org.faye.endlesscheng.t1.s3_1;

public class P42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        long sum = 0;
        long[] sumByHeight = new long[100001];
        while (left <= right) {
            while (left < right && height[left] == 0) {
                left++;
            }
            while (left < right && height[right] == 0) {
                right--;
            }
            int minH = Math.min(height[left], height[right]);
            if (left == right) {
                for (int h = 1; h <= minH; h++) {
                    if (sumByHeight[h] > 0) {
                        sumByHeight[h]--;
                    }
                }
            } else {
                int maxH = Math.max(height[left], height[right]);
                for (int h = 1; h <= maxH; h++) {
                    if (sumByHeight[h] > 0) {
                        if (height[left] >= h) {
                            sumByHeight[h]--;
                        }
                        if (height[right] >= h) {
                            sumByHeight[h]--;
                        }
                    } else {
                        if (h <= minH) {
                            sumByHeight[h] += right - left - 1;
                        }
                    }
                }
            }
            left++;
            right--;
        }
        for (int i = 0; i < sumByHeight.length; i++) {
            sum += sumByHeight[i];
        }
        return (int) sum;
    }
    //           |
    // |         |
    // |     |   |
    // | |   | | |
    // | | _ | | |
    public static void main(String[] args) {
//        System.out.println(new P42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(new P42().trap(new int[]{4,2,0,3,2,5}));
//        System.out.println(new P42().trap(new int[]{4,2,0,0,2,5}));
        System.out.println(new P42().trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }
}
