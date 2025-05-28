package Krish.src.Tree;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//Video source: https://www.youtube.com/watch?v=LgLRTaEMRVc&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=35&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
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

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    static TreeNode buildTree(int[] postOrder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
                              Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(postOrder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(postOrder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}