package org.faye.c.c422;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2 {

    class PointWithTime {
        public int i;
        public int j;
        public int time;

        public PointWithTime(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;

        PriorityQueue<PointWithTime> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        queue.offer(new PointWithTime(0, 0, 0));

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            PointWithTime pointWithTime = queue.poll();

            if (pointWithTime.i == n - 1 && pointWithTime.j == m - 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(dp[i][j] + " ");
                    }
                    System.out.println();
                }
                return pointWithTime.time;
            }

            if (pointWithTime.time > dp[pointWithTime.i][pointWithTime.j]) {
                continue;
            }

            for (int[] dir : directions) {
                int newI = pointWithTime.i + dir[0];
                int newJ = pointWithTime.j + dir[1];

                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                    int newTime = Math.max(dp[pointWithTime.i][pointWithTime.j], moveTime[newI][newJ]) + 1;
                    if (newTime < dp[newI][newJ]) {
                        dp[newI][newJ] = newTime;
                        queue.offer(new PointWithTime(newI, newJ, newTime));
                    }
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        new Q2().minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}});
        new Q2().minTimeToReach(new int[][]{{0, 1}, {1, 2}});
        new Q2().minTimeToReach(new int[][]{{0, 4}, {0, 4}});
        new Q2().minTimeToReach(new int[][]{{0, 4}, {4, 4}});
        new Q2().minTimeToReach(new int[][]{{56, 93}, {3, 38}});
        new Q2().minTimeToReach(new int[][]{{94,79,62,27,69,84},{6,32,11,82,42,30}});
    }
}
