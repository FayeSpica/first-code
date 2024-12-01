package org.faye.endlesscheng.t1.s1;

public class P2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int whiteCount = 0;

        int minWhiteCount = Integer.MAX_VALUE;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'W') {
                whiteCount++;
            }
            if (i < k - 1) {
                continue;
            }

            // update
            if (whiteCount < minWhiteCount) {
                minWhiteCount = whiteCount;
            }

            // exit
            if (chars[i - k + 1] == 'W') {
                whiteCount--;
            }
        }

        return minWhiteCount;
    }

    public static void main(String[] args) {
        System.out.println(new P2379().minimumRecolors("WBBWWBBWBW", 7));
    }
}
