package org.faye.c423;

import java.util.LinkedList;
import java.util.List;

public class P1 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        // 找出所有递增子数组 index
        // 判断有无index差为k
        int[] indexes = new int[101];

        for (int i = 0; i < nums.size(); i++) {
            boolean increase = true;
            for (int j = 1; j < k; j++) {
                if (i + j > nums.size() - 1) {
                    increase = false;
                    break;
                }
                if (nums.get(i + j) <= nums.get(i + j - 1)) {
                    increase = false;
                    break;
                }
            }
            if (k == 1 || increase) {
                indexes[i] = 1;
            }
        }

        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] == 1 && indexes[i + k] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(-15);
        list.push(9);
        System.out.println(new P1().hasIncreasingSubarrays(list, 1));;
    }
}
