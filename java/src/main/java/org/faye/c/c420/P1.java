package org.faye.c.c420;

import java.util.LinkedList;
import java.util.List;

public class P1 {
    public List<String> stringSequence(String target) {
        List<String> res = new LinkedList<>();
        StringBuilder now = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char next = 'a';
            while (next!= target.charAt(i)) {
                res.add(now.toString() + next);
                next = nextChar(next);
            }
            res.add(now.toString() + next);
            now.append(next);

        }
        return res;
    }

    public char nextChar(char now) {
        if (now == 'z') {
            return 'a';
        } else {
            return (char) (now + 1);
        }
    }
}
