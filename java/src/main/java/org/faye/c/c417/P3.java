package org.faye.c.c417;

import java.util.HashSet;
import java.util.Set;

public class P3 {
    public long countOfSubstrings(String word, int k) {
        return _countOfSubstrings(word, k) - _countOfSubstrings(word, k + 1);
    }

    public long _countOfSubstrings(String word, int k) {
        long res = 0;
        int[] counter = new int[6];
        int left = 0;
        Set<Character> vowelSet = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);
            int j = m(now);
            counter[j]++;

            if (j > 0) {
                vowelSet.add(now);
            }

            while (vowelSet.size() == 5 && counter[0] >= k) {
                char out = word.charAt(left);
                int l = m(out);
                counter[l]--;
                if (l > 0 && counter[l] == 0) {
                    vowelSet.remove(out);
                }
                left++;
            }

            res += left;
        }

        return res;
    }

    public int m(char c) {
        if (c == 'a') {
            return 1;
        } else if (c == 'e') {
            return 2;
        } else if (c == 'i') {
            return 3;
        } else if (c == 'o') {
            return 4;
        } else if (c == 'u') {
            return 5;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P3().countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
