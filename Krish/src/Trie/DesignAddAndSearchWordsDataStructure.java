package Krish.src.Trie;

//Problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/
//Video source: https://www.youtube.com/watch?v=BTf05gs_8iU&ab_channel=NeetCode
//Time complexity: O(M * (26 ^ N)), where M is the number of words to be searched, and N is the length of the word.
//Space complexity: O(M)

public class DesignAddAndSearchWordsDataStructure {
    DesignAddAndSearchWordsDataStructure[] children;
    boolean eow;

    public DesignAddAndSearchWordsDataStructure() {
        children = new DesignAddAndSearchWordsDataStructure[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        eow = false;
    }

    public void addWord(String word) {
        DesignAddAndSearchWordsDataStructure curr = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new DesignAddAndSearchWordsDataStructure();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        DesignAddAndSearchWordsDataStructure curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (DesignAddAndSearchWordsDataStructure ch : curr.children)
                    if (ch != null && ch.search(word.substring(i + 1))) return true;
                return false;
            }

            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.eow;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure obj = new DesignAddAndSearchWordsDataStructure();
        String[] words = {"bad", "dad", "mad"};
        for (String word : words) {
            obj.addWord(word);
        }
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}