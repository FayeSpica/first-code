package org.faye.endlesscheng.t1.s2_1;

public class P2516 {
    public int takeCharacters(String s, int k) {
        int maxLen = 0;

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    aCount++;
                    break;
                case 'b':
                    bCount++;
                    break;
                case 'c':
                    cCount++;
                    break;
            }
        }

        // 至多
        int aLimit = aCount - k;
        int bLimit = bCount - k;
        int cLimit = cCount - k;

        if (aLimit < 0 || bLimit < 0 || cLimit < 0) {
            return -1;
        }

        int aaCount = 0;
        int bbCount = 0;
        int ccCount = 0;

        int left = 0;
        int right = 0;

        // 满足limit的最长
        while (right < s.length()) {
            switch (s.charAt(right)) {
                case 'a':
                    aaCount++;
                    break;
                case 'b':
                    bbCount++;
                    break;
                case 'c':
                    ccCount++;
                    break;
            }

            while (aaCount > aLimit) {
                switch (s.charAt(left)) {
                    case 'a':
                        aaCount--;
                        break;
                    case 'b':
                        bbCount--;
                        break;
                    case 'c':
                        ccCount--;
                        break;
                }
                left++;
            }

            while (bbCount > bLimit) {
                switch (s.charAt(left)) {
                    case 'a':
                        aaCount--;
                        break;
                    case 'b':
                        bbCount--;
                        break;
                    case 'c':
                        ccCount--;
                        break;
                }
                left++;
            }

            while (ccCount > cLimit) {
                switch (s.charAt(left)) {
                    case 'a':
                        aaCount--;
                        break;
                    case 'b':
                        bbCount--;
                        break;
                    case 'c':
                        ccCount--;
                        break;
                }
                left++;
            }

            if (aaCount <= aLimit && bbCount <= bLimit && ccCount <= cLimit) {
                int len = right - left + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }

            right++;
        }

        return s.length() - maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new P2516().takeCharacters("aabaaaacaabc", 2));
    }
}
