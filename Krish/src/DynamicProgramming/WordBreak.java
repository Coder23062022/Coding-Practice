package Krish.src.DynamicProgramming;

import java.util.Arrays;
import java.util.List;

//Problem:https://leetcode.com/problems/word-break/
//Video source: https://www.youtube.com/watch?v=Sx9NNgInc3A&ab_channel=NeetCode
//Time complexity: O(n * w), n and w are the length of the string S and wordDict respectively
//Space complexity: O(n), n is the length of the string S
public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
//        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        List<String> wordDict = List.of("sandog", "cat");
        System.out.println(wordBreak(s, wordDict));
    }

    static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                int subStringLength = i + w.length();
                if (subStringLength <= s.length() && s.substring(i, subStringLength).equals(w)) {
                    dp[i] = dp[subStringLength];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}