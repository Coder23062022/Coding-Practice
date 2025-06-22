package Krish.src.Tree;

//Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/
//Video source: https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=28&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println("Maximum width of the binary tree is: " + widthOfBinaryTree(root));
    }

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index;
            int fast = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int curr_idx = q.peek().index - min;
                if (i == 0) fast = curr_idx;
                if (i == size - 1) last = curr_idx;

                TreeNode curr = q.peek().node;
                q.poll();

                if (curr.left != null) {
                    q.add(new Pair(curr.left, 2 * curr_idx + 1));
                }

                if (curr.right != null) {
                    q.add(new Pair(curr.right, 2 * curr_idx + 2));
                }
            }
            ans = Math.max(ans, last - fast + 1);
        }
        return ans;
    }
}