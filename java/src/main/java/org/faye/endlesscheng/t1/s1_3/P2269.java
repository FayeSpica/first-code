package org.faye.endlesscheng.t1.s1_3;

public class P2269 {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String s = String.valueOf(num);
        char[] ss = s.toCharArray();

        for (int i = 0; i + k <= ss.length; i++) {
            int d = Integer.parseInt(s.substring(i, i + k));
            if (d != 0 && num % d == 0) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P2269().divisorSubstrings(240, 2));
    }
}
