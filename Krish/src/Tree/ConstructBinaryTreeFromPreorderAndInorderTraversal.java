package src.Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static TreeNode root;

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
        int rootPosInInorderArray = inMap.get(root.data); //Find the root position in inorder array.
        int nodeCount = rootPosInInorderArray - inStart; //Find number of nodes in the left subtree of the corresponding root.

        root.left = buildTree(preOrder, preStart + 1, preStart + nodeCount, inorder, inStart, rootPosInInorderArray - 1, inMap);
        root.right = buildTree(preOrder, preStart + nodeCount + 1, preEnd, inorder, rootPosInInorderArray + 1, inEnd, inMap);

        return root;
    }
}
