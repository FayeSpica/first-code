package org.faye.c.c412;

public class P2 {
    public int countPairs(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nearEq(nums[i], nums[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public boolean nearEq(int a, int b) {
        StringBuilder aa = new StringBuilder(String.valueOf(a));
        StringBuilder bb = new StringBuilder(String.valueOf(b));

        while (aa.length() < bb.length()) {
            aa.insert(0, "0");
        }

        while (bb.length() < aa.length()) {
            bb.insert(0, "0");
        }

        int count = 0;
        int[] twoDiffIndex = new int[2];

        for (int i = 0; i < aa.length(); i++) {
            if (aa.charAt(i) != bb.charAt(i)) {
                if (count > 1) {
                    return false;
                }
                twoDiffIndex[count] = i;
                count++;
            }
        }

        // System.out.println("aa:" + aa + " bb:" + bb);

        if (count == 2) {
            return aa.charAt(twoDiffIndex[0]) == bb.charAt(twoDiffIndex[1]) && aa.charAt(twoDiffIndex[1]) == bb.charAt(twoDiffIndex[0]);
        }

        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(new P2().countPairs(new int[]{3,12,30,17,21}));
    }
}
