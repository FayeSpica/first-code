package org.faye.endlesscheng.t1.s1_2;

public class P567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            s2count[s2.charAt(i) - 'a']++;
            if (i < k - 1) {
                continue;
            } else {
                boolean found = true;

                for (int j = 0; j < 26; j++) {
                    if (s2count[j] != s1count[j]) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    return true;
                }
                s2count[s2.charAt(i - k + 1) - 'a']--;
            }
        }

        return false;
    }
}
