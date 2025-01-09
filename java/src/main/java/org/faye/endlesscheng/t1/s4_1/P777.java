package org.faye.endlesscheng.t1.s4_1;

public class P777 {
    public boolean canTransform(String start, String result) {
        // 忽略所有X
        // 下一个必须相等
        // 如果是R i <= j
        // 如果是L i >= j
        char[] s = start.toCharArray();
        char[] r = result.toCharArray();

        int i = 0;
        int j = 0;

        while (i < s.length && j < r.length) {
            while (s[i] == 'X' && i + 1 < s.length) {
                i++;
            }
            while (r[j] == 'X' && j + 1 < r.length) {
                j++;
            }
            if (s[i] != r[j]) {
                return false;
            } else {
                if (s[i] == 'R') {
                    if (i > j) {
                        return false;
                    }
                }
                if (s[i] == 'L') {
                    if (i < j) {
                        return false;
                    }
                }
            }
            i++;
            j++;
        }

        while (i < s.length) {
            if (s[i] != 'X') {
                return false;
            }
            i++;
        }

        while (j < r.length) {
            if (r[j] != 'X') {
                return false;
            }
            j++;
        }

        return i == s.length && j == r.length;
    }

    public static void main(String[] args) {
        System.out.println(new P777().canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}
