package org.faye.c.c412;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
        }

        while (k > 0) {
            int[] tmp = queue.poll();
            tmp[0] *= multiplier;
            queue.add(tmp);
            k--;
        }

        int[] arr = new int[nums.length];
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            arr[tmp[1]] = tmp[0];
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
    }
}
