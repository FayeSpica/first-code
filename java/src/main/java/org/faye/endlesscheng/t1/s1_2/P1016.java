package org.faye.endlesscheng.t1.s1_2;

public class P1016 {
    public boolean queryString(String s, int n) {
        //
        for (int i = 1; i < n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }

        return true;
    }
}
