package org.faye.endlesscheng.t1.s4_1;

import java.util.ArrayList;
import java.util.List;

public class P809 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;

        char[] ss = s.toCharArray();

        for (String word : words) {
            if (expressiveWords(ss, word.toCharArray())) {
                res ++;
            }
        }

        return res;
    }

    public boolean expressiveWords(char[] aa, char[] bb) {
        int aLeft = 0;
        int bLeft = 0;

        int aRight = 0;
        int bRight = 0;

        if (bb.length > aa.length) {
            return false;
        }

        while (aRight < aa.length && bRight < bb.length) {
            if (aa[aLeft] != bb[bLeft]) {
                return false;
            }
            while (aRight < aa.length && aa[aLeft] == aa[aRight]) {
                aRight++;
            }
            while (bRight < bb.length && bb[bLeft] == bb[bRight]) {
                bRight++;
            }
            int aLen = aRight - aLeft;
            int bLen = bRight - bLeft;

            if (bLen > aLen) {
                return false;
            } else if (bLen < aLen) {
                if (aLen >= 3) {
                    // pass
                } else {
                    return false;
                }
            } else {
                // pass
            }
            aLeft = aRight;
            bLeft = bRight;
        }

        return aRight == aa.length && bLeft == bb.length;
    }

    public static void main(String[] args) {
        System.out.println(new P809().expressiveWords("abcd", new String[]{"abc"}));
    }
}
