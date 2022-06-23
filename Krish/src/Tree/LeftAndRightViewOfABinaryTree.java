package Tree;

//Time Complexity: O(n), where n is the number of nodes in the binary tree.
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class LeftAndRightViewOfABinaryTree {
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
        System.out.println("Left view of the tree:");
        printLeftViewMeth1(root, 0);
        maxLevel = -1;
        System.out.println("\nRight view of the tree:");
        printRightViewMeth1(root, 0);

        //Another approach
        System.out.println("\nLeft view of the tree:");
        printLeftViewMeth2(root);
        System.out.println("\nRight view of the tree:");
        printRightViewMeth2(root);
    }

    static void printLeftViewMeth1(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printLeftViewMeth1(root.left, level + 1);
        printLeftViewMeth1(root.right, level + 1);
    }

    static void printRightViewMeth1(Node root, int level) {
        if (root == null)
            return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printRightViewMeth1(root.right, level + 1);
        printRightViewMeth1(root.left, level + 1);
    }

    //Video Source: https://www.youtube.com/watch?v=Lcre2oZh5YM&t=18s&ab_channel=AnujBhaiya
    static void printLeftViewMeth2(Node root) {
        List<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        for (Node node : list) {
            System.out.print(node.data + " ");
        }
    }

    static void printLeftViewUtil(Node root, List<Node> list, int level) {
        if (root == null) return;
        //When list size is equal to level that means in that level, no element is added to the list yet.
        if (list.size() == level) {
            list.add(root);
        }
        //For left view, first it will recurse in the left subtree and then right subtree.
        printLeftViewUtil(root.left, list, level + 1);
        printLeftViewUtil(root.right, list, level + 1);
    }

    static void printRightViewMeth2(Node root) {
        List<Node> list = new ArrayList<>();
        printRightViewUtil(root, list, 0);
        for (Node node : list) {
            System.out.print(node.data + " ");
        }
    }

    static void printRightViewUtil(Node root, List<Node> list, int level) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root);
//            list.set(level, root);
        }
        //For right view, first it will recurse in the right subtree and then left subtree.
        printRightViewUtil(root.right, list, level + 1);
        printRightViewUtil(root.left, list, level + 1);
    }
}