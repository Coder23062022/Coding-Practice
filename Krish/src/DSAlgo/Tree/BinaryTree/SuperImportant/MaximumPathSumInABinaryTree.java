package Krish.src.DSAlgo.Tree.BinaryTree.SuperImportant;

//Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/
//Video source: https://www.youtube.com/watch?v=WszrfSwMz58&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=17&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class MaximumPathSumInABinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int d) {
            val = d;
            this.left = this.right = null;
        }
    }

    static void main() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Maximum path sum of the binary tree is: " + maxPathSum(root));
    }

    static int res = Integer.MIN_VALUE;

    static int maxPathSum(TreeNode root) {
        maxPathHelper(root);
        return res;
    }

    static int maxPathHelper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathHelper(root.left));
        int right = Math.max(0, maxPathHelper(root.right));
        res = Math.max(res, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}