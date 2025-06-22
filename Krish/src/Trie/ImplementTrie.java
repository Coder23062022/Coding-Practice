package Krish.src.Trie;

//Problem: https://leetcode.com/problems/implement-trie-prefix-tree/
//Video source: https://www.youtube.com/watch?v=m9zawMC6QAI&ab_channel=ApnaCollege
//Time complexity: All the operations take O(L) time, where L is the length of the word
//Space complexity: O(1)

public class ImplementTrie {
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
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) return false;
            if (i == word.length() - 1 && !node.eow) return false;
            curr = node;
        }
        return true;
    }

    static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            Node node = curr.children[idx];
            if (node == null) return false;
            curr = node;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }
        System.out.println("thee -> " + search("thee"));
        System.out.println("thor -> " + search("thor"));
        System.out.println(startsWith("the"));
        System.out.println(startsWith("thi"));
    }
}