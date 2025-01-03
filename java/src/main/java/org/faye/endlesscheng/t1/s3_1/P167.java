package org.faye.endlesscheng.t1.s3_1;

public class P167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
