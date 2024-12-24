package org.faye.endlesscheng.t1.s3_1;

import java.util.Arrays;

public class P948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        // 必须 > 0
        // 优先取left朝上
        // 再取right朝下
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                left++;
                score++;
                if (maxScore < score) {
                    maxScore = score;
                }
            } else {
                if (score == 0) {
                    break;
                }
                score--;
                power += tokens[right];
                right--;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(new P948().bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }
}
