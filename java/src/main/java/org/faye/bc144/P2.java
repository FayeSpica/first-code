package org.faye.bc144;

public class P2 {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 每轮确定最小长度
            ans += distance(s.charAt(i), t.charAt(i), nextCost, previousCost);
        }
        return ans;
    }

    public long distance(char s, char target, int[] nextCost, int[] previousCost) {

        // next
        long nextRes = 0;
        char next = s;
        while (next != target) {
            nextRes+=nextCost[next - 'a'];
            next = nextChar(next);
        }

        // prev
        long prevRes = 0;
        char prev = s;
        while (prev != target) {
            prevRes+=previousCost[prev - 'a'];
            prev = prevChar(prev);
        }

        return Math.min(nextRes, prevRes);
    }

    public char nextChar(char c) {
        if (c == 'z') {
            return 'a';
        }
        return (char) (c + 1);
    }

    public char prevChar(char c) {
        if (c == 'a') {
            return 'z';
        }
        return (char) (c - 1);
    }

    public static void main(String[] args) {

    }
}
