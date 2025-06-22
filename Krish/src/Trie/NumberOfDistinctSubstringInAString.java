package Krish.src.Trie;

//Problem: https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1
//Video source: https://www.youtube.com/watch?v=m9zawMC6QAI&ab_channel=ApnaCollege
//Time complexity: O(n^2)
//Space complexity: O(logL), where L is the longest suffix of the given string

public class NumberOfDistinctSubstringInAString {
    static class Node {
        Node[] children;
        boolean eow;

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    static int distinctSubstringCount(String str) {
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i); //Find all the suffixes
            insert(suffix); //Create the tree from the suffixes
        }
        return countNodes(root);
    }

    static int countNodes(Node root) {
        if (root == null) return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int cnt = distinctSubstringCount("aaabc");
        System.out.println("Count of distinct substrings: " + cnt);
    }
}