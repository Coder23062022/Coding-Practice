package Krish.src.Tree;

//Problem: https://leetcode.com/problems/path-sum/
//Video source: https://www.youtube.com/watch?v=LSKQyOz_P8I&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(h)

public class PathSum {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int sum = 22;
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        System.out.println(hasPathSum(root, sum));
    }

    static boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.data == sum;
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}