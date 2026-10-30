package Krish.src.DSAlgo.Graph.BFS;

//Problem: https://leetcode.com/problems/word-ladder/
//Video source: https://www.youtube.com/watch?v=tRPda0rcf8E
//Time complexity: O(word.length * 26 * N), where N = wordList.length
//Space complexity: O(N), where N = wordList.length

import java.util.*;

public class WordLadderI {
    static void main() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    static class Pair {
        String first;
        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> hs = new HashSet<>(new HashSet<>(wordList));
        hs.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArr = word.toCharArray();
                    charArr[i] = ch;
                    String replacedWord = new String(charArr);

                    if (hs.contains(replacedWord)) {
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}