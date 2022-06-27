package src.Tree;

//Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//Time complexity: O(logn), Space complexity: O(1).

public class LowestCommonAncestorOfBST {
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
        root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).data);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }
}
