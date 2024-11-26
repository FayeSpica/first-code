package org.faye.endlesscheng.t1;

import java.util.Arrays;

public class P1652 {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            return decrypt_zero(code, k);
        } else if (k > 0) {
            return decrypt_plus(code, k);
        } else {
            return decrypt_minus(code, k);
        }
    }

    public int[] decrypt_minus(int[] code, int k) {
        int[] ans = new int[code.length];
        int[] doubleCode = new int[code.length * 2];
        for (int i = 0; i < doubleCode.length; i++) {
            doubleCode[i] = code[i % code.length];
        }

        int sum = 0;
        for (int i = code.length + k; i < doubleCode.length - 1; i++) {
            sum += doubleCode[i];
            if (i < code.length - 1) {
                continue;
            }

            ans[i - code.length + 1] = sum;

            sum -= doubleCode[i + k + 1];
        }

        return ans;
    }

    public int[] decrypt_plus(int[] code, int k) {
        int[] ans = new int[code.length];
        int[] doubleCode = new int[code.length * 2];
        for (int i = 0; i < doubleCode.length; i++) {
            doubleCode[i] = code[i % code.length];
        }

        int sum = 0;
        for (int i = 1; i < code.length + k; i++) {
            sum += doubleCode[i];
            if (i < k) {
                continue;
            }

            ans[i - k] = sum;
            sum -= doubleCode[i - k + 1];
        }

        return ans;
    }

    public int[] decrypt_zero(int[] code, int k) {
        int[] res = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            res[i] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new P1652().decrypt(new int[]{5, 7, 1, 4}, 3)));
        System.out.println(Arrays.toString(new P1652().decrypt(new int[]{2, 4, 9, 3}, -2)));
    }
}
