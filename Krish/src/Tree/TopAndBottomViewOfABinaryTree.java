package src.Tree;

import java.util.*;

//Video source: https://www.youtube.com/watch?v=wTloJwckQTU&ab_channel=AnujBhaiya

public class TopAndBottomViewOfABinaryTree {
    static Node root;

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
        root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.right.right = new Node(5);
        System.out.println("Top view of the binary tree is:");
        for (int i : topView(root)) {
            System.out.print(i + " ");
        }
        System.out.println("\nBottom view of the tree:");
        for (int i : bottomView(root)) {
            System.out.print(i + " ");
        }
    }

    static class Pair {
        int hd;
        Node node;

        Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    static List<Integer> topView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!map.containsKey(cur.hd)) {
                map.put(cur.hd, cur.node.data);
            }

            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }

            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    static List<Integer> bottomView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            map.put(cur.hd, cur.node.data);

            if (cur.node.left != null) {
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }

            if (cur.node.right != null) {
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
