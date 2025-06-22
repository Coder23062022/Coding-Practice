package Krish.src.Tree;

//Problem: https://leetcode.com/problems/path-sum-iii/
//Video source: https://www.youtube.com/watch?v=x87RihNvRaY&ab_channel=jayatitiwari
//Time complexity: O(n)
//Space complexity: O(h)

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int sum = 8;
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.right.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(1);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        System.out.println(pathSum(root, sum));
    }

    static int count = 0;

    static int pathSum(Node root, int targetSum) {
        getSum(root, targetSum, new ArrayList<>());
        return count;
    }

    static void getSum(Node root, long targetSum, List<Integer> currPath) {
        if (root == null) return;
        currPath.add(root.data);
        getSum(root.left, targetSum, currPath);
        getSum(root.right, targetSum, currPath);

        long temp = 0;
        for (int i = currPath.size() - 1; i >= 0; i--) {
            temp += currPath.get(i);
            if (temp == targetSum) count++;
        }

        currPath.remove(currPath.size() - 1);
    }
}