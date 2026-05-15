package Krish.src.DSAlgo.Tree.BinarySearchTree;

import java.util.ArrayList;

//Problem: https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
//Video source: https://www.youtube.com/watch?v=AiKZjCuy2k4
//Time complexity: O(m + n)
//Space complexity: O(m + n)

public class MergeTwoBSTs {
    static class Node {
        int data;
        Node left, right;

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);
        System.out.println(merge(root1, root2));
    }

    static ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrder(root1, arr1);
        inOrder(root2, arr2);

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                res.add(arr1.get(i));
                i++;
            } else {
                res.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            res.add(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            res.add(arr2.get(j));
            j++;
        }

        return res;
    }

    static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    //If the question asks to construct a balanced BST from the sorted res/array,
    //then apply ConvertSortedArrayToBST solution

//    static Node sortedArrayToBST(int[] nums) {
//        if (nums.length == 0) return null;
//        return constructBST(nums, 0, nums.length - 1);
//    }
//
//    static Node constructBST(int[] nums, int left, int right) {
//        if (left > right) return null;
//        int mid = left + (right - left) / 2;
//        Node node = new Node(nums[mid]);
//        node.left = constructBST(nums, left, mid - 1);
//        node.right = constructBST(nums, mid + 1, right);
//        return node;
//    }
}