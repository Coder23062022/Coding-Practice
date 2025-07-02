package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Problem:https://leetcode.com/problems/word-break/
//Time complexity:O((2^n) * k), for a string of length n, there are 2^n possible partitions and each substring check takes O(k) time (average substring length k)
//Space complexity: O(n), recursion stack space

public class WordBreak {
    public static void main(String[] args) {
//        String s = "ilikesamsungmobile";
//        List<String> dict = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice",
//                "and", "cream", "icecream", "man", "go", "mango");

        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");

        List<String> result = wordBreak(s, dict);
        for (String sentence : result) {
            System.out.println(sentence);
        }
    }

    static List<String> wordBreak(String s, List<String> dict) {
        List<String> res = new ArrayList<>();
        wordBreakHelper(s, new HashSet<>(dict), "", res, 0);
        return res;
    }

    static void wordBreakHelper(String s, HashSet<String> dictSet, String curr, List<String> res, int start) {
        // If start reaches the end of the string, save the result
        if (start == s.length()) {
            res.add(curr);
            return;
        }

        // Try every possible substring from the current index
        for (int end = start + 1; end <= s.length(); ++end) {
            String word = s.substring(start, end);

            // Check if the word exists in the dictionary
            if (dictSet.contains(word)) {
                String prev = curr;

                // Append the word to the current sentence
                if (!curr.isEmpty()) {
                    curr += " ";
                }
                curr += word;

                // Recurse for the remaining string
                wordBreakHelper(s, dictSet, curr, res, end);

                // Backtrack to restore the current sentence
                curr = prev;
            }
        }
    }
}