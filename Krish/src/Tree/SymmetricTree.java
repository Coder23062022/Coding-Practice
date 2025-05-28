package Krish.src.Tree;

//Problem: https://leetcode.com/problems/symmetric-tree/
//Video source: https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n), for skewed tree it will take the entire stack space

public class SymmetricTree {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println("Tree is symmetric: " + isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        //The above two lines can also be simplified to:
        //if (left == null || right == null) return left == right;

        if (left.data != right.data) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}