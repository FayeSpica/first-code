package org.faye.endlesscheng.t1.s4_1;

import java.util.Arrays;

public class LCP18 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        if (drinks.length <= 1) {
            return Math.max(staple.length, drinks.length);
        }
        if (staple.length <= 1) {
            return Math.max(staple.length, drinks.length);
        }
        Arrays.sort(staple);
        Arrays.sort(drinks);

        int counter = 0;
        // 5 10 20
        // 2 5 5
        return 0;
    }
}
