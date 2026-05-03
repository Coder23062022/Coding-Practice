package Krish.src.DSAlgo.Trie;

//Problem:https://leetcode.com/problems/word-break/
//Video source: https://www.youtube.com/watch?v=m9zawMC6QAI (Watch at 51:34 secs)
//Time complexity:O((2^n) * k), for a string of length n, there are 2^n possible partitions and each substring check takes O(k) time (average substring length k)
//Space complexity: O(n), recursion stack space

import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = List.of("leet", "code");

        //Construct trie with all the words
        for (String w : dict) insert(w);

        System.out.println(wordBreak(s));
    }

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

    static boolean search(String word) {
        Node curr = root;
        if (curr == null) return false;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) return false;
            if (i == word.length() - 1 && !node.eow) return false;
            curr = node;
        }
        return true;
    }

    static boolean wordBreak(String s) {
        //Base case
        if (s.isEmpty()) return true;

        for (int i = 1; i <= s.length(); i++) {
            String firstPart = s.substring(0, i);
            String secondPart = s.substring(i);

            if (search(firstPart) && wordBreak(secondPart)) return true;
        }
        return false;
    }
}