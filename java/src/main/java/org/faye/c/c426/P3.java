package org.faye.c.c426;

public class P3 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

        // 每棵树第i个的target最大值
        int[] targetNodes1 = new int[edges1.length + 1];

        int[] targetNodes2 = new int[edges2.length + 1];

        // 小于k的最大值
        int[] ans = new int[edges1.length];
        for (int i = 0; i < edges1.length; i++) {
            ans[i] = 0;
        }

        return targetNodes1;
    }
    
}
