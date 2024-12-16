package org.faye.endlesscheng.t1.s2_1;

public class P2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int maxLength = 1;

        int[] count = new int[10];

        int left = 0;
        int right = 1;

        char last = s.charAt(0);

        count[last - '0']++;

        int last2Index = -1;

        while (right < s.length()) {
            if (last2Index == -1) {
                // index不存在，直接增加
                if (s.charAt(right) == s.charAt(right - 1)) {
                    last2Index = right;
                }
            } else {
                // index存在，判断是否连续
                int currentAddIndex = s.charAt(right) - '0';

                // 连续 left移动至last2Index
                if (s.charAt(right) == s.charAt(right - 1)) {
                    left = last2Index;
                    last2Index = right;
                } else {
                    // 不连续
                }
            }
            int len = right - left + 1;
            if (len > maxLength) {
                maxLength = len;
            }
            right++;
        }

        return maxLength;
    }
}
