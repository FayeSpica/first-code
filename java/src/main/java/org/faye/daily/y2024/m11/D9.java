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

        // 判断是否存在(AB -> BD | AC -> CD | AC -> BD | AB -> CD)
        // cn + 0 -> cn + 1
        // cn + 2 -> cn + 3
        // cn + 2 -> cn + 1
        // cn + 0 -> cn + 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < cn) {
                    if (j < cn) {
                        // 两个圆
                        long length = ((long)Math.abs(circles[i][0] - circles[j][0]))*((long)Math.abs(circles[i][0] - circles[j][0])) + ((long)Math.abs(circles[i][1] - circles[j][1])) * ((long)Math.abs(circles[i][1] - circles[j][1]));
                        // 如果两个圆都在外面，需要重叠部分在坐标内
                        boolean iOuter = !((circles[i][0] >= 0 && circles[i][0] <= xCorner) && (circles[i][1] >= 0 && circles[i][1] <= yCorner));
                        boolean jOuter = !((circles[j][0] >= 0 && circles[j][0] <= xCorner) && (circles[j][1] >= 0 && circles[j][1] <= yCorner));

                        if (length <= ((long) (circles[i][2] + circles[j][2])) * ((long) (circles[i][2] + circles[j][2]))) {
                            if (iOuter && jOuter) {
                                // 计算点A 在内部
                                double aX = (double) (circles[i][0] * circles[j][2] + circles[j][0] * circles[i][2]) /(double) (circles[i][2] + circles[j][2]);
                                double aY = (double) (circles[i][1] * circles[j][2] + circles[j][1] * circles[i][2]) /(double) (circles[i][2] + circles[j][2]);
                                if ((aX >= 0 && aX <= xCorner) && (aY >= 0 && aY <= yCorner)) {
                                    union(i, j);
                                }
                            } else {
                                union(i, j);
                            }
                        }
                    } else {
                        if (j == cn) {
                            // AB
                            // 圆心投射到AB上的点p1
                            // 如果 在AB区间内 只要p1到圆心的距离 <= r
                            // 如果 在AB区间外 需要边界到圆心的距离 < r
                            // 外切圆不要
                            int projectionX = circles[i][0];
                            int projectionY = yCorner;
                            long length;
                            boolean outer = !((circles[i][0] >= 0 && circles[i][0] <= xCorner) && (circles[i][1] >= 0 && circles[i][1] <= yCorner));
                            if (0 <= projectionX && projectionX <= xCorner) {

                            } else if (projectionX < 0) {
                                projectionX = 0;
                            } else {
                                projectionX = xCorner;
                            }
                            length = ((long)Math.abs(circles[i][0] - projectionX))*((long)Math.abs(circles[i][0] - projectionX)) + ((long)Math.abs(circles[i][1] - projectionY)) * ((long)Math.abs(circles[i][1] - projectionY));
                            long r2 = ((long)circles[i][2]) * ((long)circles[i][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (j == cn + 1) {
                            // BD
                            int projectionX = xCorner;
                            int projectionY = circles[i][1];
                            long length;
                            boolean outer = !((circles[i][0] >= 0 && circles[i][0] <= xCorner) && (circles[i][1] >= 0 && circles[i][1] <= yCorner));
                            if (0 <= projectionY && projectionY <= yCorner) {

                            } else if (projectionY < 0) {
                                projectionY = 0;
                            } else {
                                projectionY = yCorner;
                            }
                            length = ((long)Math.abs(circles[i][0] - projectionX))*((long)Math.abs(circles[i][0] - projectionX)) + ((long)Math.abs(circles[i][1] - projectionY)) * ((long)Math.abs(circles[i][1] - projectionY));

                            long r2 = ((long)circles[i][2]) * ((long)circles[i][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (j == cn + 2) {
                            // AC
                            int projectionX = 0;
                            int projectionY = circles[i][1];
                            long length;
                            boolean outer = !((circles[i][0] >= 0 && circles[i][0] <= xCorner) && (circles[i][1] >= 0 && circles[i][1] <= yCorner));
                            if (0 <= projectionY && projectionY <= yCorner) {

                            } else if (projectionY < 0) {
                                projectionY = 0;
                            } else {
                                projectionY = yCorner;
                            }
                            length = ((long)Math.abs(circles[i][0] - projectionX))*((long)Math.abs(circles[i][0] - projectionX)) + ((long)Math.abs(circles[i][1] - projectionY)) * ((long)Math.abs(circles[i][1] - projectionY));

                            long r2 = ((long)circles[i][2]) * ((long)circles[i][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (j == cn + 3) {
                            // CD
                            int projectionX = circles[i][0];
                            int projectionY = 0;
                            long length;
                            boolean outer = !((circles[i][0] >= 0 && circles[i][0] <= xCorner) && (circles[i][1] >= 0 && circles[i][1] <= yCorner));
                            if (0 <= projectionX && projectionX <= xCorner) {

                            } else if (projectionX < 0) {
                                projectionX = 0;
                            } else {
                                projectionX = xCorner;
                            }
                            length = ((long)Math.abs(circles[i][0] - projectionX))*((long)Math.abs(circles[i][0] - projectionX)) + ((long)Math.abs(circles[i][1] - projectionY)) * ((long)Math.abs(circles[i][1] - projectionY));

                            long r2 = ((long)circles[i][2]) * ((long)circles[i][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        }
                    }
                } else {
                    if (j < cn) {
                        if (i == cn) {
                            // AB
                            int projectionX = circles[j][0];
                            int projectionY = yCorner;
                            long length;
                            boolean outer = !((circles[j][0] >= 0 && circles[j][0] <= xCorner) && (circles[j][1] >= 0 && circles[j][1] <= yCorner));
                            if (0 <= projectionX && projectionX <= xCorner) {

                            } else if (projectionX < 0) {
                                projectionX = 0;
                            } else {
                                projectionX = xCorner;
                            }
                            length = ((long)Math.abs(circles[j][0] - projectionX))*((long)Math.abs(circles[j][0] - projectionX)) + ((long)Math.abs(circles[j][1] - projectionY)) * ((long)Math.abs(circles[j][1] - projectionY));

                            long r2 = ((long)circles[j][2]) * ((long)circles[j][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (i == cn + 1) {
                            // BD
                            int projectionX = xCorner;
                            int projectionY = circles[j][1];
                            long length;
                            boolean outer = !((circles[j][0] >= 0 && circles[j][0] <= xCorner) && (circles[j][1] >= 0 && circles[j][1] <= yCorner));
                            if (0 <= projectionY && projectionY <= yCorner) {

                            } else if (projectionY < 0) {
                                projectionY = 0;
                            } else {
                                projectionY = yCorner;
                            }
                            length = ((long)Math.abs(circles[j][0] - projectionX))*((long)Math.abs(circles[j][0] - projectionX)) + ((long)Math.abs(circles[j][1] - projectionY)) * ((long)Math.abs(circles[j][1] - projectionY));

                            long r2 = ((long)circles[j][2]) * ((long)circles[j][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (i == cn + 2) {
                            // AC
                            int projectionX = 0;
                            int projectionY = circles[j][1];
                            long length;
                            boolean outer = !((circles[j][0] >= 0 && circles[j][0] <= xCorner) && (circles[j][1] >= 0 && circles[j][1] <= yCorner));
                            if (0 <= projectionY && projectionY <= yCorner) {

                            } else if (projectionY < 0) {
                                projectionY = 0;
                            } else {
                                projectionY = yCorner;
                            }
                            length = ((long)Math.abs(circles[j][0] - projectionX))*((long)Math.abs(circles[j][0] - projectionX)) + ((long)Math.abs(circles[j][1] - projectionY)) * ((long)Math.abs(circles[j][1] - projectionY));

                            long r2 = ((long)circles[j][2]) * ((long)circles[j][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        } else if (i == cn + 3) {
                            // CD
                            int projectionX = circles[j][0];
                            int projectionY = 0;
                            long length;
                            boolean outer = !((circles[j][0] >= 0 && circles[j][0] <= xCorner) && (circles[j][1] >= 0 && circles[j][1] <= yCorner));
                            if (0 <= projectionX && projectionX <= xCorner) {

                            } else if (projectionX < 0) {
                                projectionX = 0;
                            } else {
                                projectionX = xCorner;
                            }
                            length = ((long)Math.abs(circles[j][0] - projectionX))*((long)Math.abs(circles[j][0] - projectionX)) + ((long)Math.abs(circles[j][1] - projectionY)) * ((long)Math.abs(circles[j][1] - projectionY));

                            long r2 = ((long)circles[j][2]) * ((long)circles[j][2]);
                            if ((outer && length <= r2) || ((!outer) && length <= r2)) {
                                union(i, j);
                            }
                        }
                    } else {
                        // pass
                    }
                }
            }
        }

        return !(find(cn + 0) == find(cn + 1) || find(cn + 2) == find(cn + 3) || find(cn + 2) == find(cn + 1) || find(cn + 0) == find(cn + 3));
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
            System.out.println(x + " " + y);
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
        System.out.println(new D9().canReachCorner(3, 3, new int[][]{{2, 1000, 997}, {1000, 2, 997}}));;
        System.out.println(new D9().canReachCorner(15, 15, new int[][]{{1, 99, 85}, {99, 1, 85}}));;
        System.out.println(new D9().canReachCorner(5, 8, new int[][]{{4, 7, 1}}));;
        System.out.println(new D9().canReachCorner(8, 8, new int[][]{{1, 4, 1}, {3, 4, 1}, {5, 4, 1}, {7, 4, 1}}));;
        System.out.println(new D9().canReachCorner(3, 3, new int[][]{{7, 6, 5}}));;
    }
}
