package org.faye.endlesscheng.t1.s2_1;

public class P1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int cost = 0;

        int left = 0;
        int right = 0;

        cost = Math.abs(s.charAt(right) - t.charAt(right));
        if (cost <= maxCost) {
            maxLen = 1;
        }

        while (right < s.length()) {
            if (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            } else {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
                right++;
                if (right < s.length()) {
                    cost += Math.abs(s.charAt(right) - t.charAt(right));
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new P1208().equalSubstring("abcd", "bcdf", 3));
    }
}
