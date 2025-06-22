package Krish.src.Tree;

//Problem: https://leetcode.com/problems/balanced-binary-tree/
//Video source: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=15&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class BalanceBinaryTreeCheck {
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
        }
    }

    private Node createTree() {
        Node root = new Node(0);
        root.left = new Node(1);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left.right = new Node(6);
        root.left.left.right.right = new Node(8);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.left.right = new Node(7);
        return root;
    }

    private int isBalanced(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int leftSubtreeHeight = isBalanced(currentNode.left);
        int rightSubtreeHeight = isBalanced(currentNode.right);
        if (leftSubtreeHeight == -1 || rightSubtreeHeight == -1) return -1;

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    public static void main(String[] args) {
        BalanceBinaryTreeCheck object = new BalanceBinaryTreeCheck();
        Node root = object.createTree();
        if (object.isBalanced(root) == -1) {
            System.out.println("Tree is not balanced");
        } else {
            System.out.println("Tree is balanced and the height of the tree is:" + object.isBalanced(root));
        }
    }
}