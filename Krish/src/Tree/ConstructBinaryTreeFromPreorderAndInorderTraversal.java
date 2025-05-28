package Krish.src.Tree;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//Video source: https://www.youtube.com/watch?v=aZNaLrVebKQ&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=34&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    static void printTreeInorder(TreeNode root) {
        if (root == null)
            return;
        printTreeInorder(root.left);
        System.out.print(root.data + " ");
        printTreeInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("The binary tree is: ");
        printTreeInorder(root);
    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                              Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]); //Find the root from preorder traversal.
        int inRoot = inMap.get(root.data); //Find the root position in inorder array.
        int numsLeft = inRoot - inStart; //Find number of nodes in the left subtree of the corresponding root.

        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preOrder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}