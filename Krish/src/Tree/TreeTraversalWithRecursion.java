package Krish.src.Tree;

//Time complexity: O(n)
//Space complexity: O(n)

public class TreeTraversalWithRecursion {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    private Node createTree() {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        return root;
    }

    private void preOrderTraversal(Node tree) {
        if (tree == null)
            return;
        System.out.println(tree.data);
        preOrderTraversal(tree.left);
        preOrderTraversal(tree.right);
    }

    private void inOrderTraversal(Node tree) {
        if (tree == null)
            return;
        inOrderTraversal(tree.left);
        System.out.println(tree.data);
        inOrderTraversal(tree.right);
    }

    private void postOrderTraversal(Node tree) {
        if (tree == null)
            return;
        postOrderTraversal(tree.left);
        postOrderTraversal(tree.right);
        System.out.println(tree.data);
    }

    public static void main(String[] args) {
        TreeTraversalWithRecursion traversal = new TreeTraversalWithRecursion();
        Node tree = traversal.createTree();
        System.out.println("PreOrderTraversal of the tree is:");
        traversal.preOrderTraversal(tree);
        System.out.println("InOrderTraversal of the tree is:");
        traversal.inOrderTraversal(tree);
        System.out.println("PostOrderTraversal of the tree is:");
        traversal.postOrderTraversal(tree);
    }
}