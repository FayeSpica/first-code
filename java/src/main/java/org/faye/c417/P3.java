package org.faye.c417;

import java.util.HashSet;
import java.util.Set;

public class P3 {
    // todo
    public int countOfSubstrings(String word, int k) {
        int res = 0;
        int[] counter = new int[6];
        int start = 0;
        int end = 0;
        Set<Character> vowelSet = new HashSet<>();

        for (;end < word.length() && end < 5 + k; end++) {
            int i = m(word.charAt(end));
            counter[i]++;
            if (i > 0) {
                vowelSet.add(word.charAt(end));
            }
        }

        // 长度至少为 5 + k
        while (true) {
            if (end == word.length() - 1) {
                break;
            }

            System.out.println("start: " + start + " end: " + end);

            for (int j = start + 1; j <= end; j++) {
                System.out.print(word.charAt(j) + " ");
            }
            System.out.println();

            // 什么时候end++
            // 什么时候start++

            if (k == counter[0] && vowelSet.size() == 5) {
                System.out.println("!");
                res++;

                // 如果end是0 且 start是0
                int end_i = m(word.charAt(end));
                int start_i = m(word.charAt(start));

                if (end_i == 0 && start_i == 0) {
                    start++;
                    end++;
                } else if (end_i == 0 && start_i > 0) {
                    counter[start_i]--;
                } else if (end_i > 0 && start_i == 0) {
                    counter[end_i]++;
                    end++;
                } else if (end_i > 0 && start_i > 0) {

                }
            }

//            if (k == counter[0] && vowelSet.size() == 5) {
//
//                System.out.println("!");
//
//                res++;
//
//                if (end < word.length() - 1) {
//                    end++;
//                    i = m(word.charAt(end));
//                    counter[i]++;
//                    if (i > 0) {
//                        vowelSet.add(word.charAt(end));
//                    }
//                } else {
//                    if (start < word.length() - 1) {
//                        start++;
//                        i = m(word.charAt(start));
//                        counter[i]--;
//                        if (i > 0 && counter[i] == 0) {
//                            vowelSet.remove(word.charAt(start));
//                        }
//                    }
//                }
//            } else {
//                if (counter[0] > k) {
//                    start++;
//                    i = m(word.charAt(start));
//                    counter[i]--;
//                    if (i > 0 && counter[i] == 0) {
//                        vowelSet.remove(word.charAt(start));
//                    }
//                } else {
//                    if (end < word.length() - 1) {
//                        end++;
//                        i = m(word.charAt(end));
//                        counter[i]++;
//                        if (i > 0) {
//                            vowelSet.add(word.charAt(end));
//                        }
//                    } else {
//                        if (start < word.length() - 1) {
//                            start++;
//                            i = m(word.charAt(start));
//                            counter[i]--;
//                            if (i > 0 && counter[i] == 0) {
//                                vowelSet.remove(word.charAt(start));
//                            }
//                        }
//                    }
//                }
//            }
        }

        return res;
    }

    public int m(char c) {
        if (c == 'a') {
            return 1;
        } else if (c == 'e') {
            return 2;
        } else if (c == 'i') {
            return 3;
        } else if (c == 'o') {
            return 4;
        } else if (c == 'u') {
            return 5;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new P3().countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
