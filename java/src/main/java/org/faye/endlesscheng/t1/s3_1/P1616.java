package org.faye.endlesscheng.t1.s3_1;

public class P1616 {
    // todo
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }

        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int left = 0;
        int right = b.length() - 1;
        return false;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
