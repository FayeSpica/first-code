package org.faye.c417;

public class P2 {
    public int countOfSubstrings(String word, int k) {
        int res = 0;
        int[] counter = new int[6];
        int start = 0;
        int end = 0;
        counter[m(word.charAt(end))]++;
        while (end < word.length()) {
            if (k == counter[0]) {
                res++;
            } else if ()
        }
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
}
