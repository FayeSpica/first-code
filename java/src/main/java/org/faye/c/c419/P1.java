package org.faye.c.c419;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1 {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        int[] counter = new int[51];

        int start = 0;
        int end = k - 1;

        for (int i = start; i < end; i++) {
            counter[nums[i]]++;
        }

        int i = 0;

        while (end < nums.length) {
            counter[nums[end]]++;
            System.out.println(Arrays.toString(counter));
            res[i++] = count(counter, x);
            counter[nums[start]]--;
            start++;
            end++;
        }

        return res;
    }

    static class T {
        public int value;
        public int index;

        public T(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int x() {
            return index * value;
        }
    }

    public int count(int[] counter, int x) {
        int sum = 0;
        PriorityQueue<T> queue = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value) {
                return - a.index + b.index;
            } else {
                return - a.value + b.value;
            }
        });
        for (int i = 50; i > 0; i--) {
            if (counter[i] > 0) {
                queue.add(new T(counter[i], i));
            }
        }

        while (x > 0 && !queue.isEmpty()) {
            sum += queue.poll().x();
            x--;
        }

        return sum;
    }
}
