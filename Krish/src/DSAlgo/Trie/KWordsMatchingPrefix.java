package Krish.src.DSAlgo.Trie;

//Problem: Find out any k words which starts with the given prefix
//Time complexity: O(L), where L is the length of the word
//Space complexity: O(1)

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

    static boolean startsWith(String word, String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length() && i < word.length(); i++) {
            int idx1 = word.charAt(i) - 'a';
            int idx2 = prefix.charAt(i) - 'a';

            if (curr.children[idx2] == null) return false;

            if ((char) (idx1 + 'a') == (char) (idx2 + 'a')) {
                curr = curr.children[idx2];
            } else {
                return false;
            }
        }
        return true;
    }

    static void main() {
        String[] words = {"app", "apple", "application", "apply", "apt"};
        String prefix = "appl";
        int k = 3;

        for (String word : words) {
            insert(word);
            if (startsWith(word, prefix) && k > 0) {
                System.out.println(word);
                k--;
            }
        }
    }
}