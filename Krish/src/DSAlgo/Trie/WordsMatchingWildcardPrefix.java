package Krish.src.DSAlgo.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordsMatchingWildcardPrefix {
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

    static List<String> findMatchingWords(String pattern) {
        List<String> result = new ArrayList<>();
        findMatches(root, pattern, 0, new StringBuilder(), result);
        return result;
    }

    static void findMatches(Node curr, String pattern, int index, StringBuilder word, List<String> result) {
        // Entire pattern is matched, collect all complete words below this node.
        if (index == pattern.length()) {
            collectWords(curr, word, result);
            return;
        }

        char ch = pattern.charAt(index);

        // '*' matches exactly one character
        if (ch == '*') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    char c = (char) (i + 'a');
                    word.append(c);
                    findMatches(curr.children[i], pattern, index + 1, word, result);
                    word.deleteCharAt(word.length() - 1);
                }
            }
        } else {
            int idx = ch - 'a';
            if (curr.children[idx] != null) {
                word.append(ch);
                findMatches(curr.children[idx], pattern, index + 1, word, result);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    static void collectWords(Node curr, StringBuilder word, List<String> result) {
        // Found a complete word
        if (curr.eow) {
            result.add(word.toString());
        }

        // Explore all children
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                char c = (char) (i + 'a');
                word.append(c);
                collectWords(curr.children[i], word, result);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    static void main() {
        String[] words = {"app", "apple", "abcp", "application", "apply", "apm"};
        String prefix = "a*p";

        for (String word : words) {
            insert(word);
        }

        List<String> matchingWords = findMatchingWords(prefix);
        System.out.println(matchingWords);
    }
}