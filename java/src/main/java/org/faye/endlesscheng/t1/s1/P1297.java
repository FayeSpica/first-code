package org.faye.endlesscheng.t1.s1;

import java.util.HashMap;
import java.util.Map;

public class P1297 {

    // todo: slow 10%
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        for (int i = minSize; i <= maxSize; i++) {
            int freq = maxFreq(s, maxLetters, i);
            if (freq > max) {
                max = freq;
            }
        }
        return max;
    }

    public int maxFreq(String s, int maxLetters, int k) {
        int max = 0;
        Map<String, Integer> counter = new HashMap<>();
        Map<Character, Integer> cCounter = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char appendStr = s.charAt(i);
            sb.append(appendStr);
            cCounter.put(appendStr, cCounter.getOrDefault(appendStr, 0) + 1);

            if (i < k - 1) {
                continue;
            }
//            System.out.println(sb.toString() + " | c=" + cCounter.size());
            if (cCounter.size() <= maxLetters) {
                int freq = counter.getOrDefault(sb.toString(), 0) + 1;
                counter.put(sb.toString(), freq);
                if (freq > max) {
                    max = freq;
                }
            }

            char deleteChar = sb.charAt(0);
            sb.deleteCharAt(0);

            int t = cCounter.get(deleteChar);
            if (t > 1) {
                cCounter.put(deleteChar, t - 1);
            } else {
                cCounter.remove(deleteChar);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P1297().maxFreq("aababcaab", 2, 3, 4));
        System.out.println(new P1297().maxFreq("aaaa", 1, 3, 3));
    }
}
