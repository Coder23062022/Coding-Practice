package Krish.src.Tree;

//Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/
//Video source: https://www.youtube.com/watch?v=WszrfSwMz58&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=17&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class MaximumPathSumInABinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Maximum path sum of the binary tree is: " + maxPathSum(root));
    }

    static int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }

    static int maxPath(TreeNode root, int[] maxValue) {
        if (root == null) return 0;
        int left = Math.max(0, maxPath(root.left, maxValue));
        int right = Math.max(0, maxPath(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + root.data);
        return root.data + Math.max(left, right);
    }
}