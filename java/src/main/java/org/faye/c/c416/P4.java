package org.faye.c.c416;

public class P4 {
    public long validSubstringCount(String word1, String word2) {
        // word count
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];

        for (int i = 0; i < word2.length(); i++) {
            counter2[word2.charAt(i) - 'a']++;
        }

        long ans = 0;

        int left = 0;

        for (int i = 0; i < word1.length(); i++) {
            counter1[word1.charAt(i) - 'a']++;
            while (biggerEq(counter1, counter2)) {
                counter1[word1.charAt(left) - 'a']--;
                left++;
            }
            ans += left;
        }

        return ans;
    }

    public boolean biggerEq(int[] counter1, int[] counter2) {
        for (int i = 0; i < 26; i++) {
            if (counter1[i] < counter2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P4().validSubstringCount("bcca", "abc"));
        System.out.println(new P4().validSubstringCount("abcabc", "abc"));
    }
}
