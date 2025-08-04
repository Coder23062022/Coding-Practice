package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/longest-palindromic-substring/
//Video source: https://www.youtube.com/watch?v=XYQecbcd6_c&ab_channel=NeetCode
//Time complexity: O(n^2)
//Space complexity: O(1)

public class LongestPalindromicSubstring {
    static String result;
    static int maxLength;

    public static void main(String[] args) {
        String s = "babad";
//        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            findAllPalindromes(s, i, i + 1); //For even length palindrome
            findAllPalindromes(s, i, i); //For odd length palindrome
        }
        return result;
    }

    //Here, we are expanding the window from the middle of the string.
    //That's why 'low' value we are decrementing and 'high' value we are incrementing.
    static void findAllPalindromes(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            if (high - low + 1 > maxLength) {
                result = s.substring(low, high + 1);
                maxLength = high - low + 1;
            }
            low--;
            high++;
        }
    }
}