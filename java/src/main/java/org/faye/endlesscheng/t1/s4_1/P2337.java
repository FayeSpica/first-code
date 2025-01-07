package org.faye.endlesscheng.t1.s4_1;

public class P2337 {
    public boolean canChange(String start, String target) {
        char[] startS = start.toCharArray();
        char[] targetS = target.toCharArray();
        int i = 0, j = 0;
        for (; i < startS.length && j < targetS.length; ) {
            boolean notLR = false;
            if (startS[i] == '_') {
                notLR = true;
                i++;
            }
            if (targetS[j] == '_') {
                notLR = true;
                j++;
            }
            if (notLR) {
                continue;
            }

            if (startS[i] != targetS[j]) {
                return false;
            } else {
                if (startS[i] == 'L' && i < j) {
                    return false;
                } else if (startS[i] == 'R' && i > j) {
                    return false;
                }
            }

            i++;
            j++;
        }

        while (i < startS.length) {
            if (startS[i] != '_') {
                return false;
            }
            i++;
        }

        while (j < targetS.length) {
            if (targetS[j] != '_') {
                return false;
            }
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P2337().canChange("_L__R__R_", "L______RR"));
        System.out.println(new P2337().canChange("R_L_", "__LR"));
    }
}
