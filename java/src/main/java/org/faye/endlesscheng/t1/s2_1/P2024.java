package org.faye.endlesscheng.t1.s2_1;

public class P2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] arr = answerKey.toCharArray();
        return Math.max(maxF(arr, k), maxT(arr, k));
    }

    public int maxF(char[] arr, int k) {
        int maxLen = 1;
        int left = 0;
        int right = 0;
        int tCount = 0;

        while (right < arr.length) {
            if (arr[right] == 'F') {
            } else {
                tCount++;
            }

            while (tCount > k) {
                if (arr[left] == 'F') {
                } else {
                    tCount--;
                }
                left++;
            }

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }

            right++;
        }
        return maxLen;
    }

    public int maxT(char[] arr, int k) {
        int maxLen = 1;
        int left = 0;
        int right = 0;
        int fCount = 0;

        while (right < arr.length) {
            if (arr[right] == 'F') {
                fCount++;
            } else {
            }

            while (fCount > k) {
                if (arr[left] == 'F') {
                    fCount--;
                } else {

                }
                left++;
            }

            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }

            right++;
        }
        return maxLen;
    }
}
