package Krish.src.DSAlgo.Trie;

public class KWordsMatchingPrefix {
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

    static Node root;

    public KWordsMatchingPrefix() {
        root = new Node();
    }

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
            if (curr.children[idx] == null) return false;
            if (i == word.length() - 1 && !curr.children[idx].eow) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    static boolean startsWith(String prefix) {
        Node curr = root;
        if (curr == null) return false;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    static void main() {
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