package org.faye.c.c416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<>(Arrays.asList(bannedWords));

        int counter = 0;

        for (String s : message) {
            if (banned.contains(s)) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P1().reportSpam(new String[]{"o","k","r","y","w","r"}, new String[]{"k","b","s","a","s","u"}));
    }
}
