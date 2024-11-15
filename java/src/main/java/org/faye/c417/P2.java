package org.faye.c417;

public class P2 {
    public int countOfSubstrings(String word, int k) {
        int res = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 4; j < word.length(); j++) {
                // start = i
                // end = j
                int[] counter = new int[6];
                for (int l = i; l <= j; l++) {
                    counter[m(word.charAt(l))]++;
                }
                if (counter[0] == k && counter[1] >= 1 && counter[2] >= 1 && counter[3] >= 1 && counter[4] >= 1 && counter[5] >= 1) {
                    res++;
                }
            }
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
//        System.out.println(new P2().countOfSubstrings("ieaouqqieaouqq", 1));
//        System.out.println(new P2().countOfSubstrings("cuiaeo", 0));
        System.out.println(new P2().countOfSubstrings("ieiaoud", 0));
    }
}
