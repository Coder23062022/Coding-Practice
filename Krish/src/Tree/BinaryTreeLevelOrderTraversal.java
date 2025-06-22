package Krish.src.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
//Video source: https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=8&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

public class BinaryTreeLevelOrderTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
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
            List<Integer> currentList = new ArrayList<>();

            //Iterating till the size of the queue every time to traverse all the nodes in a level and collect all the
            //children they have.
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentList.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }
}