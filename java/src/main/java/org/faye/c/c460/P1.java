package org.faye.c.c460;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P1 {

    public long maximumMedianSum(int[] nums) {
        long res = 0;
        Arrays.sort(nums);
        // 1 1 2 2 3 3
        // 尽量选2最大的 + 一个最小的
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            deque.addLast(nums[i]);
        }
        while (!deque.isEmpty()) {
            deque.removeFirst();
            deque.removeLast();
            res += deque.removeLast();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
