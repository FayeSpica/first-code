package org.faye.endlesscheng.t1.s1_2;

import java.util.*;

public class P30 {

    // todo slow 5%
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int[] totalCount = new int[26];
        int step = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            char[] w = words[i].toCharArray();
            step = w.length;
            for (int j = 0; j < w.length; j++) {
                totalCount[w[j] - 'a']++;
            }
        }

        int k = 0;
        for (int i = 0; i < words.length; i++) {
            k += words[i].length();
        }

        char[] ss = s.toCharArray();

        int[] sCount = new int[26];
        for (int i = 0; i < ss.length; i++) {
            sCount[ss[i] - 'a']++;
            if (i < k - 1) {
                continue;
            } else {
                boolean sameCountTotal = true;

                for (int j = 0; j < 26; j++) {
                    if (totalCount[j] != sCount[j]) {
                        sameCountTotal = false;
                        break;
                    }
                }

                if (sameCountTotal) {
                    // find every word count
                    Map<String, Integer> cMap = new HashMap<>();
//                    if (step == 1) {
//                        for (int j = i - k + 1; j < i + 1; j++) {
//                            String sub = ""+s.charAt(j);
//                            cMap.put(sub, cMap.getOrDefault(sub, 0) + 1);
//                        }
//                    } else {
//
//                    }
                    for (int j = i - k + 1; j < i + 1; j+=step) {
                        String sub = s.substring(j, j + step);
                        cMap.put(sub, cMap.getOrDefault(sub, 0) + 1);
                    }

                    if (cMap.keySet().containsAll(map.keySet()) && map.keySet().containsAll(cMap.keySet())) {
                        boolean match = true;
                        for (String key: cMap.keySet()) {
                            if (!Objects.equals(cMap.get(key), map.get(key))) {
                                match = false;
                                break;
                            }
                        }
                        if (match) {
                            result.add(i - k + 1);
                        }
                    }
                }

                sCount[ss[i - k + 1] - 'a']--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new P30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new P30().findSubstring("a", new String[]{"a"}));
        System.out.println(new P30().findSubstring("aaa", new String[]{"a", "a"}));
    }
}
