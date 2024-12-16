package org.faye.endlesscheng.t1.s2_1;

import java.util.HashMap;

public class P904 {
    public int totalFruit(int[] fruits) {
        int totalMax = 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 1;
        map.put(fruits[0], 1);
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if (map.size() <= 2) {
                //
            } else {
                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }
            int max = right - left + 1;
            if (max > totalMax) {
                totalMax = max;
            }
            right++;
        }

        return totalMax;
    }
}
