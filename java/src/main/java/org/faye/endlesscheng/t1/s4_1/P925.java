package org.faye.endlesscheng.t1.s4_1;

public class P925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] a = name.toCharArray();
        char[] b = typed.toCharArray();

        int aLeft = 0;
        int aRight = 0;

        int bLeft = 0;
        int bRight = 0;

        while (aRight < a.length && bRight < b.length) {

            if (a[aLeft] != b[bLeft]) {
                return false;
            }

            while (aRight < a.length && a[aLeft] == a[aRight]) {
                aRight++;
            }
            while (bRight < b.length && b[bLeft] == b[bRight]) {
                bRight++;
            }

            int aLen = aRight - aLeft;
            int bLen = bRight - bLeft;

            if (aLen > bLen) {
                return false;
            }

            aLeft = aRight;
            bLeft = bRight;
        }

        return aRight == a.length && bRight == b.length;
    }
}
