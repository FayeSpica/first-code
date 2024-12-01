package org.faye.endlesscheng.t1.s1;

import java.util.*;

public class P1100 {

    // todo slow 20%
    public int numKLenSubstrNoRepeats(String s, int k) {
        int sum = 0;
        char[] c = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            if (i < k - 1) {
                continue;
            }

            if (map.size() == k) {
                sum++;
            }

            int cc = map.get(c[i - k + 1]);
            map.put(c[i - k + 1], cc - 1);
            if (cc == 1) {
                map.remove(c[i - k + 1]);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new P1100().numKLenSubstrNoRepeats("havefunonleetcode", 5));
    }
}
