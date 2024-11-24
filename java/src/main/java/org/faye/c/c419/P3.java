package org.faye.c.c419;

public class P3 {
    public int countWinningSequences(String s) {
        // F >> E
        // E >> W
        // W >> F
        int[][][] dp = new int[s.length()][][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new int[2 * s.length()][3];

            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = new int[3];
            }
        }

//        for (int i = 0; i < s.length(); i++) {
//            dp[0][0][c('F')] =
//        }
        return 0;
    }

    public int win(char bob, char alice) {
        if (bob == alice) {
            return 0;
        }
        if ((bob == 'F' && alice == 'E') || (bob == 'E' && alice == 'W') || (bob == 'W' && alice == 'F')) {
            return 1;
        }
        return -1;
    }

    public int c(char c) {
        if (c == 'F') {
            return 0;
        }
        if (c == 'E') {
            return 1;
        }
        if (c == 'W') {
            return 2;
        }
        return -1;
    }
}
