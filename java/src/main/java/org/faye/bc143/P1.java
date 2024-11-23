package org.faye.bc143;

public class P1 {
    public int smallestNumber(int n, int t) {
        int c = n;
        while (!isDiv(c, t)) {
            c++;
        }
        return c;
    }

    public boolean isDiv(int d, int t) {
        if (t == 1) {
            return true;
        }

        int temp = d;
        int sum = 1;
        while (temp > 0) {
            sum *= temp % 10;
            temp /= 10;
        }
        return sum % t == 0;
    }

    public static void main(String[] args) {
        new P1().smallestNumber(10, 2);
    }
}
