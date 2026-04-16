package Krish.src.DSAlgo.Tree;

//Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//Video source: https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=45&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class kthSmallestElementInBST {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        kthSmallest(root, 3);
        System.out.println("k-th smallest element is: " + result);
    }

    static void kthSmallest(TreeNode root, int k) {
        traverse(root, k);
    }

    //Do the Inorder traversal of the BST so that values will come in sorted order and increase a counter everytime it
    //iterates to check with k.
    static void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        traverse(root.right, k);
    }
}