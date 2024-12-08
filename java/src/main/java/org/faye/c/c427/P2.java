package org.faye.c.c427;

public class P2 {
    public int maxRectangleArea(int[][] points) {
        // 10个点 暴力搜
        // 找出x y 相邻的4个点
        // a b
        // c d
        int maxArea = -1;
        for (int a = 0; a < points.length; a++) {
            for (int b = 0; b < points.length; b++) {
                for (int c = 0; c < points.length; c++) {
                    for (int d = 0; d < points.length; d++) {
                        if (a == b || a == c || a == d || b == c || b == d || c == d) {
                            continue;
                        }
                        if (
                                points[a][1] == points[b][1]
                                && points[c][1] == points[d][1]
                                && points[a][0] == points[c][0]
                                && points[b][0] == points[d][0]
                        ) {
                            if (
                                    points[b][0] - points[a][0] > 0
                                    && points[b][0] - points[a][0] == points[d][0] - points[c][0]
                                    && points[a][1] - points[c][1] > 0
                                    && points[a][1] - points[c][1] == points[b][1] - points[d][1]
                            ) {
                                // is rect
                                int xMin = points[a][0];
                                int xMax = points[b][0];
                                int yMin = points[c][1];
                                int yMax = points[a][1];

                                boolean matched = true;
                                for (int i = 0; i < points.length; i++) {
                                    if (i == a || i == b || i == c || i == d) {
                                        continue;
                                    }
                                    if (points[i][0] >= xMin && points[i][0] <= xMax && points[i][1] >= yMin && points[i][1] <= yMax) {
                                        matched = false;
                                    }
                                }

                                if (matched) {
                                    // match
                                    int area = (xMax - xMin) * (yMax - yMin);
                                    if (area > maxArea) {
                                        maxArea = area;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new P2().maxRectangleArea(new int[][]{
                {1, 1},
                {1, 3},
                {3, 1},
                {3, 3},
        }));
    }
}
