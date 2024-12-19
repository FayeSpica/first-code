package org.faye.endlesscheng.t1.s2_1;

import java.util.ArrayList;
import java.util.List;

public class P2271 {
    // todo
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = 0;

        int left = 0;

        if (tiles.length == 1) {
            return Math.min(tiles[0][1] - tiles[0][0], carpetLen);
        }

        List<int[]> gaps = new ArrayList<>();

        for (int i = 0; i < tiles.length - 1; i++) {
            int[] a = tiles[i];
            int[] b = tiles[i + 1];

            if (a[1] != b[0]) {
                gaps.add(new int[]{a[1] + 1, b[0] - 1});
            }
        }

        int start = tiles[0][0];
        int end = tiles[tiles.length - 1][1];
        // [[-1, -1] [6,9], [19, 19], [26. 29], [33, 33]]

        int right = 1;

        while (right < tiles.length) {

            right++;
        }

        return -1;
    }
}
