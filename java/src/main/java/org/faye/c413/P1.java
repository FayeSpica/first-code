package org.faye.c413;

public class P1 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0) - 'a' + 1;
        int y1 = coordinate1.charAt(1) - '0';

        int x2 = coordinate2.charAt(0) - 'a' + 1;
        int y2 = coordinate2.charAt(1) - '0';

        return black(x1, y1) == black(x2, y2);
    }

    public boolean black(int x, int y) {
        return (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0);
    }
}
