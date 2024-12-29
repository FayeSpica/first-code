package org.faye.c.c430;

public class P2 {
    public String answerString(String word, int numFriends) {
        // 字典序最大
        // 最长
        char wordLongestChar = word.charAt(0);

        int aLeft = 0;
        int aRight = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (wordLongestChar < c) {
                wordLongestChar = c;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == wordLongestChar) {
                aLeft = i;
                aRight = i;
                break;
            }
        }



        // a b
        // a c g


        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == wordLongestChar) {
                for (int j = i + 1; j < word.length(); j++) {
                    if (bigger(word, i, j, aLeft, aRight)) {
                        aLeft = i;
                        aRight = i;
                    }
                }
            }
        }

        return word.substring(aLeft, aRight);
    }

    public boolean bigger(String word, int aLeft, int aRight, int bLeft, int bRight) {
        int n = Math.min(aRight - aLeft + 1, bRight - bLeft + 1);
        int i = 0;
        while (i < n) {
            char a = word.charAt(aLeft + i);
            char b = word.charAt(aRight + i);
            if (a == b) {
                i++;
            } else if (a < b) {
                return false;
            } else {
                return true;
            }
        }

        if (aRight - aLeft > bRight - bLeft) {
            return true;
        } else {
            return false;
        }
    }
}
