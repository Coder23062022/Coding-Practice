package src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    static TreeNode root;
    static int result = 0;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrderTraversalUsingBFS(root);
        for (List<Integer> nodes : result) {
            System.out.println(nodes);
        }
    }

    static List<List<Integer>> levelOrderTraversalUsingBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                current.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(current);
        }
        return result;
    }
}
