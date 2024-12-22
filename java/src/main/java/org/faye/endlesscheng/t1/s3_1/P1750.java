package org.faye.endlesscheng.t1.s3_1;

public class P1750 {

    // todo slow
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] ss = s.toCharArray();

        while (left < right) {
            if (ss[left] != ss[right]) {
                return 1 + right - left;
            }
            while (left < right && ss[left] == ss[left + 1]) {
                left++;
            }
            while (left < right && ss[right] == ss[right - 1]) {
                right--;
            }
            left++;
            right--;
        }

        if (left > right) {
            return 0;
        }

        return 1 + right - left;
    }

    public static void main(String[] args) {
//        System.out.println(new P1750().minimumLength("cabaabac"));
//        System.out.println(new P1750().minimumLength("ca"));
        System.out.println(new P1750().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
