package org.faye.bc.bc144;

public class P1 {
    public boolean canAliceWin(int n) {
        // bob 10 8
        int count = 0;
        while (n >= 0) {
            n -= 10 - count;
            count++;
            // System.out.println(n + " | " + count);
            if (n < 0) {
                return count % 2 == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P1().canAliceWin(12));
        System.out.println(new P1().canAliceWin(1));
        System.out.println(new P1().canAliceWin(50));
    }
}
