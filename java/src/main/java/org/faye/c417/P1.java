package org.faye.c417;

import java.util.LinkedList;
import java.util.List;

public class P1 {
    public char kthCharacter(int k) {
        // word = "a";
        List<Character> words = new LinkedList<>();
        words.add('a');
        while (words.size() < k) {
            int size = words.size();
            for (int i = 0; i < size; i++) {
                char now = words.get(i);
                if (now == 'z') {
                    words.add('a');
                } else {
                    words.add((char) (now + 1));
                }
            }
        }
        return words.get(k - 1);
    }
}
