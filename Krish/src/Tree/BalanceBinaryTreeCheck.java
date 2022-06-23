package Tree;

public class BalanceBinaryTreeCheck {

    //Inner class to create a node
    static class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
        }
    }

    Node root;

    private Node createTree() {
        this.root = new Node(0);
        root.left = new Node(1);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left.right = new Node(6);
        root.left.left.right.right = new Node(8);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.left.right = new Node(7);

        //Balanced Binary Tree
		/*root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);*/
        return root;
    }

    private int isBalanced(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int leftSubtreeHeight = isBalanced(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;

        int rightSubtreeHeight = isBalanced(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;

        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    public static void main(String[] args) {
        BalanceBinaryTreeCheck object = new BalanceBinaryTreeCheck();
        Node tree = object.createTree();
        if (object.isBalanced(tree) == -1) {
            System.out.println("Tree is not balanced");
        } else {
            System.out.println("Tree is balanced and the height of the tree is:" + object.isBalanced(tree));
        }
    }
}
