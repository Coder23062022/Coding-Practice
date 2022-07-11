package src.DynamicProgramming;

//Problem: https://leetcode.com/problems/longest-palindromic-substring/
//Time complexity: O(n^2)

public class LongestPalindromicSubstring {
    static String result;
    static int maxLength;

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            findAllPalindromes(s, i, i + 1);
            findAllPalindromes(s, i, i);
        }
        return result;
    }

    static void findAllPalindromes(String s, int low, int high) {
        while (low >= 0 && high < s.length() - 1 && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }

        if (high - (low + 1) >= maxLength) {
            result = s.substring(low + 1, high);
            maxLength = high - (low + 1);
        }
    }
}
