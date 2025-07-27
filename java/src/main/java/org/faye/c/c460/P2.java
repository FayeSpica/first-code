package org.faye.c.c460;

public class P2 {
    public long numOfSubsequences(String s) {
        // L插在最前面是最多的
        // T插在最后面是最多的
        // C插在L T数量的中间位置 最多
        long[] prefixL = new long[s.length()];
        long[] suffixT = new long[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            prefixL[i] = (i == 0 ? 0 : prefixL[i - 1]) + (s.charAt(i) == 'L' ? 1 : 0);
        }

        for (int i = s.length() - 1; i >= 0 ; i--) {
            suffixT[i] = suffixT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
        }
        int maxIndex = -1;
        long maxValue = 0;
        // 如果在i位置插入C 能增加的量
        for (int i = 1; i < suffixT.length - 1; i++) {
            long value = prefixL[i - 1] * suffixT[i];
            if (maxValue < value) {
                maxValue = value;
                maxIndex = i;
            }
        }
        // LLLLLL  C TTT
        // LLL C TTTTTT
        String c = s;
        if (maxIndex >= 0 ) {
            c = s.substring(0, maxIndex) + "C" + s.substring(maxIndex);
        }
//        System.out.println(c);
        return Math.max(Math.max(subNumOfSubsequences("L" + s), subNumOfSubsequences(s + "T")), subNumOfSubsequences(c));
    }
    public long subNumOfSubsequences(String s) {
        // L 的数量
        // C 的数量
        // T 的数量
        // 前缀和 第i个位置L的数量
        // prefixL[i]
        // prefixC[i]
        // prefixT[i]
        long[] prefixL = new long[s.length()];
        long[] suffixT = new long[s.length() + 1];


        for (int i = 0; i < s.length(); i++) {
            prefixL[i] = (i == 0 ? 0 : prefixL[i - 1]) + (s.charAt(i) == 'L' ? 1 : 0);
        }

        for (int i = s.length() - 1; i >= 0 ; i--) {
            suffixT[i] = suffixT[i + 1] + (s.charAt(i) == 'T' ? 1 : 0);
        }

        long sum = 0;
        // 遍历每个C，计算和
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C' && i > 0 && i < s.length() - 1) {
                sum += prefixL[i - 1]*suffixT[i + 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        P2 p = new P2();
        System.out.println(p.numOfSubsequences("LT"));
    }
}
