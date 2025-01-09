package org.faye.endlesscheng.t1.s2_4;

public class P2401 {

    // todo slow 8%
    public int longestNiceSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        // bit 位最多一个
        int[] bit1Count = new int[32];

        int longest = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            boolean overflow = false;
            for (int j = 0; j < 32; j++) {
                int t = (nums[right] >> j) & 1;
                bit1Count[j]+=t;
                if (bit1Count[j] > 1) {
                    overflow = true;
                }
            }

            while (overflow) {
                overflow = false;
                for (int j = 0; j < 32; j++) {
                    int t = (nums[left] >> j) & 1;
                    bit1Count[j]-=t;
                    if (bit1Count[j] > 1) {
                        overflow = true;
                    }
                }
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new P2401().longestNiceSubarray(new int[] { 1, 3, 8, 48, 10 }));
    }
}
