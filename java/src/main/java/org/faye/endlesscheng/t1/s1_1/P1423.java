package org.faye.endlesscheng.t1.s1_1;

public class P1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] points = new int[cardPoints.length * 2];
        for (int i = 0; i < points.length; i++) {
            points[i] = cardPoints[i % cardPoints.length];
        }

        int maxScore = 0;
        int score = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length + k; i++) {
            score += points[i];
            if (i < cardPoints.length - 1) {
                continue;
            }

            if (score > maxScore) {
                maxScore = score;
            }
            score -= points[i - k + 1];
        }

        return maxScore;
    }

    public static void main(String[] args) {
//        System.out.println(new P1423().maxScore(new int[] {1,2,3,4,5,6,1}, 3));
        System.out.println(new P1423().maxScore(new int[] {100,40,17,9,73,75}, 3));
    }
}
