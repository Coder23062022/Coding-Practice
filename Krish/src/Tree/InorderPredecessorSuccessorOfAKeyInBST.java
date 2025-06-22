package Krish.src.Tree;

import java.util.ArrayList;
import java.util.List;

//Problem: https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
//Video source: https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=49&ab_channel=takeUforward
//Time complexity: O(logn)
//Space complexity: O(1)

public class InorderPredecessorSuccessorOfAKeyInBST {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);
        root.left.right.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        findPreSuc(root, 6).forEach(x -> System.out.println(x.data));
    }

    static List<TreeNode> findPreSuc(TreeNode root, int key) {
        List<TreeNode> res = new ArrayList<>();
        res.add(findPre(root, key));
        res.add(findSuc(root, key));
        return res;
    }

    static TreeNode findPre(TreeNode root, int key) {
        TreeNode pre = null;
        while (root != null) {
            if (root.data < key) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pre;
    }

    static TreeNode findSuc(TreeNode root, int key) {
        TreeNode suc = null;
        while (root != null) {
            if (root.data <= key) {
                root = root.right;
            } else {
                suc = root;
                root = root.left;
            }
        }
        return suc;
    }
}