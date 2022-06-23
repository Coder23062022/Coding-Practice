package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Time Complexity: O(n), where n is the number of nodes in the binary tree.
//Space complexity: O(n)

public class PrintOutlineOfABinaryTree {
    static Node root;
    static int maxLevel = -1;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        List<Integer> list = new ArrayList<>();
        printLeftViewMeth1(root, 0, list);
        maxLevel = -1;
        Collections.reverse(list); // To reverse the left view list so that it will print in bottom-up fashion in left view
        printRightViewMeth1(root.right, 1, list);
        System.out.println("Outline view of the tree:");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

        //Another approach
        List<Node> leftView = new ArrayList<>();
        printLeftViewMeth2(root, leftView);
        Collections.reverse(leftView);
        List<Node> rightView = new ArrayList<>();
        printRightViewMeth2(root.right, rightView);
        System.out.println("\nOutline view of the tree:");
        for (Node node : leftView) {
            System.out.print(node.data + " ");
        }
        for (Node node : rightView) {
            System.out.print(node.data + " ");
        }
    }

    static void printLeftViewMeth1(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        printLeftViewMeth1(root.left, level + 1, list);
    }

    static void printRightViewMeth1(Node root, int level, List<Integer> list) {
        if (root == null)
            return;

        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        printRightViewMeth1(root.right, level + 1, list);
    }

    static void printLeftViewMeth2(Node root, List<Node> list) {
        printLeftViewUtil(root, list, 0);
    }

    static void printLeftViewUtil(Node root, List<Node> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root);
        }
        printLeftViewUtil(root.left, list, level + 1);
    }

    static void printRightViewMeth2(Node root, List<Node> list) {
        printRightViewUtil(root, list, 0);
    }

    static void printRightViewUtil(Node root, List<Node> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root);
        }
        printRightViewUtil(root.right, list, level + 1);
    }
}