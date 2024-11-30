package org.faye.endlesscheng.t1;

import java.util.HashMap;
import java.util.Map;

public class P2107 {

    // slow 10%
    public int shareCandies(int[] candies, int k) {

        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        }
        if (k == 0) {
            return map.size();
        }
        for (int i = 0; i < candies.length; i++) {
            map.put(candies[i], map.getOrDefault(candies[i], 0) - 1);
            if (map.get(candies[i]) == 0) {
                map.remove(candies[i]);
            }
            if (i < k - 1) {
                continue;
            }

            if (map.size() > max) {
                max = map.size();
            }

            map.put(candies[i - k + 1], map.getOrDefault(candies[i - k + 1], 0) + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P2107().shareCandies(new int[]{1,2,2,3,4,3}, 3));
    }
}
