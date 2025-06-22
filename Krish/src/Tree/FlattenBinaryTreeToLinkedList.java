package Krish.src.Tree;

//Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Video source: https://www.youtube.com/watch?v=dU2Z5HWSGM0&ab_channel=ShradhaKhapra
//Video source: https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=38&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class FlattenBinaryTreeToLinkedList {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        flatten(root);
        printLinkedList(root);
    }

    static void printLinkedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.data + "->");
            //As all the left children are null, all the data reside only in the right children.
            //So we will only go in the right direction to print.
            root = root.right;
        }
        System.out.print("null");
    }

    static TreeNode nextRight = null;

    static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}