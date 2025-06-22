package Krish.src.Tree;

//Problem: https://leetcode.com/problems/validate-binary-search-tree/
//Video source: https://www.youtube.com/watch?v=f-sj7I5oXEI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=46&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class CheckIfBinaryTreeIsBST {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.left.left.right = new TreeNode(9);
        root.left.left.right.left = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);
        root.right.right.left = new TreeNode(16);
        System.out.println(isValidBST(root));
    }

    static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.data >= max || root.data <= min) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
}