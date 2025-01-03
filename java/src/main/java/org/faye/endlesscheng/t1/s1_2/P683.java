package org.faye.endlesscheng.t1.s1_2;

import java.util.TreeSet;

public class P683 {
    public int kEmptySlots(int[] bulbs, int k) {
        // 1 3 2 | k = 1
        // 1 0 0
        // 1 0 1
        // 1 1 1

        // 1 3 4 2
        int kk = k + 2;
        // left
        // right
        // 1 3
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            set.add(bulbs[i]);
            int min = bulbs[i] - k - 1;
            int max = bulbs[i] + k + 1;

            Integer lower = set.lower(bulbs[i]);
            Integer higher = set.higher(bulbs[i]);

            if (set.contains(min) && lower != null) {
                // not enough
                // (min, bulbs[i]) is not in set
                // check lower == min
                if (lower == min) {
                    return i + 1;
                }
            }
            if (set.contains(max) && higher != null) {
                // (bulbs[i], max) is not in set
                // check higher == max
                if (higher == max) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
