package org.faye.endlesscheng.t1.s2_1;

import java.util.HashMap;
import java.util.Map;

public class P3 {

    // slow 7%
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int maxLength = 1;

        Map<Character, Integer> counter = new HashMap<>();

        counter.put(s.charAt(right), 1);

        while (right < s.length()) {
            int max = 0;
            for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }

            if (max > 1) {
                counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                left++;
            } else {
                int len = right - left + 1;
                maxLength = Math.max(maxLength, len);
                right++;
                if (right < s.length()) {
                    counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new P3().lengthOfLongestSubstring("abcabcbb"));
    }
}
