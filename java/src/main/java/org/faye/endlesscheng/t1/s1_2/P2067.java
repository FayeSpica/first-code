package org.faye.endlesscheng.t1.s1_2;

import java.util.HashMap;
import java.util.Map;

public class P2067 {
    // todo slow 9%
    public int equalCountSubstrings(String s, int count) {
        int res = 0;
        char[] ss = s.toCharArray();
        for (int k = count; k <= 26 * count; k+=count) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < ss.length; i++) {
                map.put(ss[i], map.getOrDefault(ss[i], 0) + 1);
                if (i < k - 1) {
                    continue;
                } else {
                    boolean match = true;
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (entry.getValue() != count) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        res++;
                    }

                    int newV = map.getOrDefault(ss[i - k + 1], 0) - 1;
                    if (newV == 0) {
                        map.remove(ss[i - k + 1]);
                    } else {
                        map.put(ss[i - k + 1], newV);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P2067().equalCountSubstrings("aaabcbbcc", 3));
    }
}
