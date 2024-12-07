package org.faye.bc.bc145;

public class P1 {
    public int minOperations(int[] nums, int k) {
        int[] counter = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        for (int i = 0; i < k; i++) {
            if (counter[i] > 0) {
                return -1;
            }
        }

        int s = 0;
        for (int i = k + 1; i < counter.length; i++) {
            if (counter[i] > 0) {
                s += 1;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new P1().minOperations(new int[]{5,2,5,4,5}, 2));
    }
}
