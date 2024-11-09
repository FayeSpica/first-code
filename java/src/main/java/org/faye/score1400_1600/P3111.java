package org.faye.score1400_1600;

import java.util.Arrays;
import java.util.LinkedList;

public class P3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] xArr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            xArr[i] = points[i][0];
        }

        Arrays.sort(xArr);

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < xArr.length; i++) {
            if (queue.isEmpty() || (queue.peek() < xArr[i])) {
                queue.push(xArr[i]);
            }
        }

        int[] rangeArr = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            rangeArr[i] = queue.get(i);
        }

//        System.out.println(Arrays.toString(rangeArr));

        int counter = 0;
        int start = rangeArr[0];
        for (int i = 0; i < rangeArr.length;) {
            int end = start + w;

            // select next start
        }

        return 0;
    }
}
