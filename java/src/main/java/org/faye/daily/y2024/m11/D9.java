package org.faye.daily.y2024.m11;

public class D9 {
    int[] parent;
    int[] rank;

    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        // A B
        // C D

        // n 个园
        int n = circles.length + 4;
        int cn = circles.length;

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // 判断是否存在(AB -> BD | AC -> CD)
        // cn + 0 -> cn + 1
        // cn + 2 -> cn + 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < cn) {
                    if (j < cn) {
                        // 两个圆
                        long length = ((long)Math.abs(circles[i][0] - circles[j][0]))*((long)Math.abs(circles[i][0] - circles[j][0])) + ((long)Math.abs(circles[i][1] - circles[j][1])) * ((long)Math.abs(circles[i][1] - circles[j][1]));
                        if (length <= ((long)(circles[i][2] + circles[j][2])) * ((long)(circles[i][2] + circles[j][2])) ) {
                            union(i, j);
                        }
                    } else {
                        if (j == cn) {
                            // AB
                            long ab_length = yCorner - circles[i][1];
                            long bd_length = xCorner - circles[i][0];
                            if (ab_length < 0 || bd_length < 0) { // 圆心在矩形外 需要同时满足 AB 与 BD length > -r
                                if (ab_length > -circles[i][2] && (bd_length > -circles[i][2] || bd_length >= 0)) {
                                    union(i, j);
                                }
                            }
                            else if (ab_length <= circles[i][2]) {
                                union(i, j);
                            }
                        } else if (j == cn + 1) {
                            // BD
                            long ab_length = yCorner - circles[i][1];
                            long bd_length = xCorner - circles[i][0];
                            if (ab_length < 0 || bd_length < 0) { // 圆心在矩形外 需要同时满足 x + r < xCorner  与y + r < yCorner
                                if (bd_length > -circles[i][2] && (ab_length > -circles[i][2] || ab_length >= 0)) {
                                    union(i, j);
                                }
                            }
                            else if (bd_length <= circles[i][2]) { // 圆心在矩形内
                                union(i, j);
                            }
                        } else if (j == cn + 2) {
                            // AC
                            long length = circles[i][0];
                            if (length <= circles[i][2]) {
                                union(i, j);
                            }
                        } else if (j == cn + 3) {
                            // CD
                            long length = circles[i][1];
                            if (length <= circles[i][2]) {
                                union(i, j);
                            }
                        }
                    }
                } else {
                    if (j < cn) {
                        if (i == cn) {
                            // AB
                            long ab_length = yCorner - circles[j][1];
                            long bd_length = xCorner - circles[j][0];
                            if (ab_length < 0 || bd_length < 0) { // 圆心在矩形外 需要同时满足 AB 与 BD length > -r
                                if (ab_length > -circles[j][2] && (bd_length > -circles[j][2] || bd_length >= 0)) {
                                    union(i, j);
                                }
                            }
                            else if (ab_length <= circles[j][2]) {
                                union(i, j);
                            }
                        } else if (i == cn + 1) {
                            // BD
                            long ab_length = yCorner - circles[j][1];
                            long bd_length = xCorner - circles[j][0];
                            if (ab_length < 0 || bd_length < 0) { // 圆心在矩形外 需要同时满足 x + r < xCorner  与y + r < yCorner
                                if (bd_length > -circles[j][2] && (ab_length > -circles[j][2] || ab_length >= 0)) {
                                    union(i, j);
                                }
                            }
                            else if (bd_length <= circles[j][2]) { // 圆心在矩形内
                                union(i, j);
                            }
                        } else if (i == cn + 2) {
                            // AC
                            long length = circles[j][0];
                            if (length <= circles[j][2]) {
                                union(i, j);
                            }
                        } else if (i == cn + 3) {
                            // CD
                            long length = circles[j][1];
                            if (length <= circles[j][2]) {
                                union(i, j);
                            }
                        }
                    } else {
                        // pass
                    }
                }
            }
        }

        return !(find(cn + 0) == find(cn + 1) || find(cn + 2) == find(cn + 3));
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        new D9().canReachCorner(3, 3, new int[][]{{2, 1000, 997}, {1000, 2, 997}});
    }
}
