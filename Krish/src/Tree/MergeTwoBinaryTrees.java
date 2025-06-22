package Krish.src.Tree;

//Problem: https://leetcode.com/problems/merge-two-binary-trees/
//Video source: https://www.youtube.com/watch?v=QHH6rIK3dDQ&ab_channel=NeetCode
//Video source: https://www.youtube.com/watch?v=Rt-mneSQg9E&ab_channel=jayatitiwari
//Time complexity: O(n)
//Space complexity: O(h)

public class MergeTwoBinaryTrees {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        // construct the first Binary Tree
        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.right = new Node(6);

        // construct the second Binary Tree
        //       4
        //     /   \
        //    1     7
        //   /     /  \
        //  3     2    6

        Node root2 = new Node(4);
        root2.left = new Node(1);
        root2.right = new Node(7);
        root2.left.left = new Node(3);
        root2.right.left = new Node(2);
        root2.right.right = new Node(6);

        Node root = mergeTrees(root1, root2);
        inorder(root);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    static Node mergeTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.data += root2.data;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}