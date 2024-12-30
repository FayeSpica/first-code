package org.faye.endlesscheng.t1.s6_1;

public class P1578 {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int left = 0;
        int right = 0;

        char[] arr = colors.toCharArray();

        while (left < arr.length) {
            int maxTime = neededTime[left];
            int sum = 0;
            while (right < arr.length) {
                if (arr[left] == arr[right]) {
                    int time = neededTime[right];
                    sum += time;
                    if (time > maxTime) {
                        maxTime = time;
                    }
                    right++;
                } else {
                    right--;
                    break;
                }
            }
            if (right == arr.length) {
                right = arr.length - 1;
            }

            System.out.println(left + " | " + right);

            if (right + 1 - left > 1) {
                cost += sum - maxTime;
            }

            left = right + 1;
            right = left;
        }

        return cost;
    }

    public static void main(String[] args) {
        System.out.println(new P1578().minCost("abaac", new int[]{1,2,3,4,5}));
    }
}
