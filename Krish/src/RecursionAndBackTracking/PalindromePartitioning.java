package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/palindrome-partitioning/
//Video source: https://www.youtube.com/watch?v=aZ0B1eWkSVU&ab_channel=ApnaCollege
//Time Complexity: O(n * 2^n)
//Space Complexity: O(n), recursion stack space

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, new ArrayList<>(), res);
        return res;
    }

    static void partitionHelper(String s, List<String> curr, List<List<String>> res) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String part = s.substring(0, i + 1);
            if (isPalindrome(part)) {
                curr.add(part);
                partitionHelper(s.substring(i + 1), curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.contentEquals(sb);
    }
}