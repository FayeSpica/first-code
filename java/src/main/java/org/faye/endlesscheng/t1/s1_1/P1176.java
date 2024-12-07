package org.faye.endlesscheng.t1.s1_1;

public class P1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        // next k
        int score = 0;
        int sum = 0;
        for (int i = 0; i < calories.length; i++) {
            sum += calories[i];
            if (i < k - 1) {
                continue;
            }
            if (sum < lower) {
                score--;
            }
            if (sum > upper) {
                score++;
            }
            sum -= calories[i - k + 1];
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new P1176().dietPlanPerformance(new int[]{6,13,8,7,10,1,12,11}, 6, 5, 37));
    }
}
