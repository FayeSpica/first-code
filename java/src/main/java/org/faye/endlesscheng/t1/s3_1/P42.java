package org.faye.endlesscheng.t1.s3_1;

public class P42 {
    public int trap(int[] height) {
        // 0,1,0,2,1,0,1,3,2,1,2,1

        int left = 0;
        int right = height.length - 1;
        int sum = 0;

        int leftMax = -1;
        int rightMax = -1;
        while (left <= right) {
            // water[i] =
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
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
