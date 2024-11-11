package org.faye.c420;

public class P2 {
    public int numberOfSubstrings(String s, int k) {
        int res = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (count(s, start, end) == k) {
                res += s.length() - end;
                start++;
            } else {
                end++;
            }
        }
        return res;
    }

    public int count(String s, int start, int end) {
        int[] arr = new int[26];
        for (int i = start; i <= end ; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > sum) {
                sum = arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        new P2().numberOfSubstrings("abacb", 2);
        System.out.println(new P2().numberOfSubstrings("abcde", 1));;
    }
}
