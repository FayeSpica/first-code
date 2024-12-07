package org.faye.endlesscheng.t1.s1_1;

public class P1456 {
    public int maxVowels(String s, int k) {
        int maxVowelCount = 0;
        int vowelCount = 0;
        int left = 0;
        int right = Math.min(s.length() - 1, k - 1);

        for (int i = left; i <= right ; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        maxVowelCount = vowelCount;

        while (right < s.length() - 1) {
            int exit = right + 1 - k;
            int enter = right + 1;
            if (isVowel(s.charAt(enter))) {
                vowelCount++;
            }
            if (isVowel(s.charAt(exit))) {
                vowelCount--;
            }
            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
            }
            right++;
        }

        return maxVowelCount;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(new P1456().maxVowels("abciiidef", 3));
    }
}
