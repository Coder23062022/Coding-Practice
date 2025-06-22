package Krish.src.Tree;

//Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/
//Video source: https://www.youtube.com/watch?v=PUfADhkq1LI&ab_channel=ShradhaKhapra
//Video source: https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=37&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
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
        System.out.println(inorderTraversal(root));
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode inorderPredecessor = curr.left;
                while (inorderPredecessor.right != null && inorderPredecessor.right != curr) {
                    inorderPredecessor = inorderPredecessor.right;
                }

                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = curr; //Create the te
                    curr = curr.left;
                } else {
                    inorderPredecessor.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}