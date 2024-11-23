package org.faye.c412;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P3 {
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
            tmp[0] = (int) ((long) tmp[0] * multiplier % 1000000007);
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
//        System.out.println(Arrays.toString(new P3().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
//        System.out.println(Arrays.toString(new P3().getFinalState(new int[]{100000, 2000}, 2, 1000000)));
        System.out.println(Arrays.toString(new P3().getFinalState(new int[]{66307295,441787703,589039035,322281864}, 900900704, 641725)));
    }
}
