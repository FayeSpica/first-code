package org.faye.c.c425;

import java.util.HashMap;
import java.util.Map;

public class P2 {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        // 按k分割子串
        // 判断子串集合是否完全一致
        Map<String, Integer> sMap = subStrMaps(s, k);
        Map<String, Integer> tMap = subStrMaps(t, k);
        return sMap.equals(tMap);
    }

    public Map<String, Integer> subStrMaps(String s, int k) {
        Map<String, Integer> res = new HashMap<>();
        int m = s.length() / k;
        for (int i = 0; i < k; i++) {
            String key = s.substring(i * m, (i + 1) * m);
            res.put(key, res.getOrDefault(key, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P2().isPossibleToRearrange("aabbcc", "bbaacc", 2));
        System.out.println(new P2().isPossibleToRearrange("abcd", "cdab", 2));
    }
}
