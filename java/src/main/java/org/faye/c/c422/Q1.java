package org.faye.c.c422;

public class Q1 {
    public boolean isBalanced(String num) {
        long odd_sum = 0;
        long even_sum = 0;
        for (int i = 0; i < num.length(); i++) {
            long digit = num.charAt(i) - '0';
            if (i % 2 == 0) {
                even_sum += digit;
            } else {
                odd_sum += digit;
            }
        }
        System.out.println(even_sum);
        System.out.println(odd_sum);
        return odd_sum == even_sum;
    }

    public static void main(String[] args) {
        new Q1().isBalanced("24123");
    }
}
