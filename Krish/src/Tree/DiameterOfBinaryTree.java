package Krish.src.Tree;

//Problem: https://leetcode.com/problems/diameter-of-binary-tree/
//Video source: https://www.youtube.com/watch?v=Rezetez59Nk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=16&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class DiameterOfBinaryTree {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Diameter of the binary tree is: " + diameterOfBinaryTree(root));
    }

    static int diameter = 0;

    static int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return diameter;
    }

    static int diameterHelper(TreeNode node) {
        if (node == null) return 0;
        int lh = diameterHelper(node.left);
        int rh = diameterHelper(node.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}