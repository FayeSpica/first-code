package org.faye.c.c419;


import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
        this.left = left;
        this.right = right;
    }
 }

public class P2 {

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(value -> -value));
        count(queue, root, k, true);
        if (queue.size() < k) {
            return -1;
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    public int[] count(PriorityQueue<Integer> queue, TreeNode root, int k, boolean twoLeaf) {
        int[] count = new int[2]; // dep  count
        if (root == null) {
            return count;
        }

        int[] left = count(queue, root.left, k, root.left != null && root.right != null);
        int[] right = count(queue, root.right, k, root.left != null && root.right != null);
        count[0] = Math.max(left[0], right[0]) + 1;
        count[1] = left[1] + right[1] + 1;
        System.out.println("depth:" + count[0] + " count:" + count[1]);
        if (twoLeaf && Math.pow(2, count[0] + 1) - 1 == count[1]) {
            queue.add(count[1]);
        }
        return count;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(value -> -value));
        queue.add(1);
        queue.add(3);
        queue.add(2);

        System.out.println(queue.peek());
    }
}
