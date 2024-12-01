package org.faye.endlesscheng.t1.s1;

public class P1461 {

    // todo: slow
    public boolean hasAllCodes(String s, int k) {
        //
        // k = 1 2
        // k = 2 4
        // k = 3 8 2**n
        // [1, 2**n]
        // int[]
        int n = (int) Math.pow(2, k);
        int[] counter = new int[n];
        for (int i = 0; i < s.length(); i++) {
            if (i < k - 1) {
                continue;
            }

            // update
            // convert [i - k + 1, i] to digit
            int d = b2d(s, i - k + 1, i);
            counter[d]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 0) {
                return false;
            }
        }

        return true;
    }

    public int b2d(String s, int left, int right) {
        int d = 0;
        for (int i = right; i >= left; i--) {
            d += s.charAt(i) == '1' ? (int) Math.pow(2, right - i) : 0;
        }
        return d;
    }

    public static void main(String[] args) {
        System.out.println(new P1461().hasAllCodes("00110110", 2));
        System.out.println(new P1461().hasAllCodes("0110", 1));
        System.out.println(new P1461().hasAllCodes("0110", 2));
//        System.out.println(Math.pow(2, 21));
    }
}
