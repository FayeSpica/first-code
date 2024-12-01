package org.faye.c.c426;

public class P1 {
    public int smallestNumber(int n) {
        // len = 1
        int len = 1;
        int cN = 1;
        while (cN <= n) {
            len++;
            cN += (int) Math.pow(2, len - 1);
        }

        return cN;
    }
}
