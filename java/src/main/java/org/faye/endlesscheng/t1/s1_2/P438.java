package org.faye.endlesscheng.t1.s1_2;

import java.util.ArrayList;
import java.util.List;

public class P438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        char[] sChars = s.toCharArray();
        int k = p.length();

        for (int i = 0; i < sChars.length; i++) {
            sCount[sChars[i] - 'a']++;
            if (i < k - 1) {
                continue;
            } else {
                boolean found = true;

                for (int j = 0; j < 26; j++) {
                    if (sCount[j] != pCount[j]) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    result.add(i - k + 1);
                }

                sCount[sChars[i - k + 1] - 'a']--;
            }
        }

        return result;
    }
}
