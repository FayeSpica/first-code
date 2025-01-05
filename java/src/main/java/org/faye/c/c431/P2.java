package org.faye.c.c431;

import java.util.*;

public class P2 {
    public long calculateScore(String s) {
        long res = 0;
        Map<Character, Deque<Integer>> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new LinkedList<>());
        }

        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length; i++) {
            char mirror = mirror(ss[i]);
            Deque<Integer> iList = map.get(ss[i]);
            Deque<Integer> mirrorList = map.get(mirror);
            if (!mirrorList.isEmpty()) {
                int j = mirrorList.removeLast();
                res += i - j;

            } else {
                iList.add(i);
            }
        }

        return res;
    }

    public char mirror(char c) {
        int ci = c - 'a';
        int mirror = 25 - ci;
        return (char) ('a' + mirror);
    }

    public static void main(String[] args) {
        System.out.println(new P2().calculateScore("aczzx"));
    }
}
