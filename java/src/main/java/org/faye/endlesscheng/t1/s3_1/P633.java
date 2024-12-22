package org.faye.endlesscheng.t1.s3_1;

public class P633 {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        for (; left <= right;) {
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P633().judgeSquareSum(32));
    }
}
