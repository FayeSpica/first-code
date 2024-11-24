package org.faye.c.c416;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P2 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        Arrays.sort(workerTimes);
        // select min
        // int[3]
        // int[0] total time 1 3 6 10 15
        // int[1] unit cost  1 1 1 1 1
        // int[2] count      1 2 3 4 5
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(value -> value[0]));
        for (int i = 0; i < workerTimes.length; i++) {
            queue.add(new long[]{workerTimes[i], workerTimes[i], 1});
        }

        long maxTime = 0;

        while (mountainHeight > 0) {
            // 每次选出最小cost的工人
            long[] minTotalTimeWorker = queue.poll();
            if (minTotalTimeWorker[0] > maxTime) {
                maxTime = minTotalTimeWorker[0];
            }
            mountainHeight -= 1;
            minTotalTimeWorker[2]++;
            minTotalTimeWorker[0] = minTotalTimeWorker[1] * (minTotalTimeWorker[2] * (minTotalTimeWorker[2] + 1)) / 2;
            queue.add(minTotalTimeWorker);
        }

        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(new P2().minNumberOfSeconds(100000, new int[]{1}));;
    }
}
