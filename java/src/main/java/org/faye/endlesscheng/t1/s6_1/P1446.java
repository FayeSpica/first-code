package org.faye.endlesscheng.t1.s6_1;

public class P1446 {
    public int maxPower(String s) {
        int max = 0;
        int left = 0;
        int right = 0;

        while (left < s.length()) {
            while (right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    right++;
                } else {
                    right--;
                    break;
                }
            }

            if (right >= s.length()) {
                right = s.length() - 1;
            }

//            System.out.println(left + " | " + right);

            int len = right + 1 - left;

            if (len > max) {
                max = len;
            }

            left = right + 1;
            right = left;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P1446().maxPower("leetcode"));
    }
}
