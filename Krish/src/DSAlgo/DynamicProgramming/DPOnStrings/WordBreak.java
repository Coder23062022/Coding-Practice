package Krish.src.DSAlgo.DynamicProgramming.DPOnStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Problem:https://leetcode.com/problems/word-break/
//Video source: https://www.youtube.com/watch?v=oBUpyPZ08zU&t=10s
//Time complexity:O((2^n) * k), for a string of length n, there are 2^n possible partitions and each substring check takes O(k) time (average substring length k)
//Space complexity: O(n), recursion stack space

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(wordBreakWithRecursion(s, new HashSet<>(dict), 0));
    }

    static boolean wordBreakWithRecursion(String s, HashSet<String> wordDict, int index) {
        if (index == s.length())
            return true;

//        if (wordDict.contains(s)) return true;

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);
            if (wordDict.contains(word)) {
                if (wordBreakWithRecursion(s, wordDict, end)) return true;
            }
        }
        return false;
    }

    static boolean wordBreakWithMemoization(String s, HashSet<String> wordDict, int index) {
        Boolean[] dp = new Boolean[s.length()];
        return memoizationHelper(s, new HashSet<>(wordDict), 0, dp);
    }

    static boolean memoizationHelper(String s, HashSet<String> wordDict, int index, Boolean[] dp) {
        if (index == s.length())
            return true;

        if (dp[index] != null) return dp[index];

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);
            if (wordDict.contains(word)) {
                if (memoizationHelper(s, wordDict, end, dp)) return dp[index] = true;
            }
        }
        return dp[index] = false;
    }
}