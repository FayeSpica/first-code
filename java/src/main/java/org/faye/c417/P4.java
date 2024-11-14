package org.faye.c417;

public class P4 {
    public char trim(char c) {
        if (c == 'z' + 1) {
            return 'a';
        } else {
            return c;
        }
    }
    public char kthCharacter(long k, int[] operations) {
//        System.out.println(k);
        if (k == 1) {
            return 'a';
        }
        if (k == 2) {
            return trim((char) (kthCharacter(1, operations) + operations[0]));
        }
        // 10
        // 2^n = 16
        // 1 2 4 8 16 32
        long count = (long) (Math.log(k) / Math.log(2));
//        System.out.println("count:" + count);
        if (Math.pow(2, count) == k) {
            count--;
        }
        // 16

        long half = (long) Math.pow(2, count);
//        System.out.println("half:" + half);
        long preK = k - half;
//        System.out.println(preK);
        return trim((char) (kthCharacter(preK, operations) + operations[(int) (count)]));
    }

    public static void main(String[] args) {
//        System.out.println(new P4().kthCharacter(5, new int[]{0, 0, 0}));
//        System.out.println(new P4().kthCharacter(10, new int[]{0, 1, 0, 1}));
//        System.out.println(new P4().kthCharacter(1, new int[]{1, 0}));
//        System.out.println(new P4().kthCharacter(25, new int[]{0, 0, 0, 0, 1}));
        System.out.println(new P4().kthCharacter(100000000000000L, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
