package Krish.src.Tree;

//Problem: https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
//Video source: https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=45&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class kthLargestElementInBST {
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
        kthLargest(root, 3);
        System.out.println("k-th largest element is: " + result);
    }

    static void kthLargest(TreeNode root, int k) {
        traverse(root, k);
    }

    //Do the reverse Inorder traversal of the BST so that values will come in descending order and increase a counter everytime it
    //iterates to check with k.
    static void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.right, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        traverse(root.left, k);
    }
}
