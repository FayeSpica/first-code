package org.faye.c.c430;

public class P1 {
    public int minimumOperations(int[][] grid) {
        int sum = 0;

        for (int c = 0; c < grid[0].length; c++) {
            for (int i = 1; i < grid.length; i++) {
                int prev = grid[i - 1][c];
                int cur = grid[i][c];
                if (cur <= prev) {
                    grid[i][c] = prev + 1;
                    sum += prev + 1 - cur;
                }
            }
        }

        return sum;
    }
}
