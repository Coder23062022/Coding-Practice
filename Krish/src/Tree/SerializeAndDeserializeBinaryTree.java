package Krish.src.Tree;

//Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//Video source: https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=36&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(n)

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = serialize(root);
        System.out.println("After Serialization: " + s);
        TreeNode res = deserialize(s);
        System.out.println("After Deserialization: ");
        printTreePreorder(res);
    }

    static void printTreePreorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printTreePreorder(root.left);
        printTreePreorder(root.right);
    }

    static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.data).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    static TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}