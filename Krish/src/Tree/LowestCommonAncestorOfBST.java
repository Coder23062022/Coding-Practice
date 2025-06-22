package Krish.src.Tree;

//Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//Video source: https://www.youtube.com/watch?v=cX_kPV_foZc&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=47&ab_channel=takeUforward
//Time complexity: O(logn)

public class LowestCommonAncestorOfBST {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(lowestCommonAncestorIterative(root, root.left, root.right).data);
    }

    //Recursive (Space complexity: O(n))
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.data < root.data && q.data < root.data) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.data > root.data && q.data > root.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return root;
    }

    //Iterative (Space complexity: O(1))
    static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.data < root.data && q.data < root.data) {
                root = root.left;
            } else if (p.data > root.data && q.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}