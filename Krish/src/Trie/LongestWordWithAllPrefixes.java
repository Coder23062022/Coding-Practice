package Krish.src.Trie;

//Problem: https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1
//Video source: https://www.youtube.com/watch?v=m9zawMC6QAI&ab_channel=ApnaCollege
//Time complexity: O(n*m), where n is the size of array words[] and m is the maximum length of the string.
//Space complexity: O(26*n*m)

public class LongestWordWithAllPrefixes {
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

    static String ans = "";

    static String longestValidWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        longestWord(root, sb);
        return ans;
    }

    static void longestWord(Node root, StringBuilder sb) {
        if (root == null) return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                sb.append((char) (i + 'a'));
                if (sb.length() > ans.length()) ans = sb.toString();
                longestWord(root.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
//        String[] words = {"geeks", "gfg", "geeksforgeeks"};
        System.out.println(longestValidWord(words));
    }
}