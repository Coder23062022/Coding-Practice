package src.Tree;

//Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class kthSmallestElementInBST {
    static TreeNode root;
    static int count = 0, result = 0;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        kthSmallestElement(root, 3);
        System.out.println("k-th smallest element is: " + result);
    }

    static void kthSmallestElement(TreeNode root, int k) {
        if (root == null) return;
        kthSmallestElement(root.left, k);
        count++;
        if (count == k) result = root.data;
        kthSmallestElement(root.right, k);
    }
}
