package org.faye.endlesscheng.t1.s6_1;

import java.util.HashMap;
import java.util.Map;

public class P1839 {

    // todo slow 8.70%
    public int longestBeautifulSubstring(String word) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        int maxLen = 0;
        int left = 0;
        int right = 1;
        char prev = word.charAt(left);

        while (right < word.length()) {
            char r = word.charAt(right);
            if (map.get(r) - map.get(prev) == 1 || map.get(r) - map.get(prev) == 0) {
                int len = right + 1 - left;
                if (len > maxLen && r == 'u' && word.charAt(left) == 'a') {
                    maxLen = len;
                }
                prev = r;
                right++;
            } else {
                left = right;
                prev = word.charAt(left);
                right++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new P1839().longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }
}
