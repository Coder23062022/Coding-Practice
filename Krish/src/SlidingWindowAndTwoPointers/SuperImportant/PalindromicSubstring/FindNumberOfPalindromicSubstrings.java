package Krish.src.SlidingWindowAndTwoPointers.SuperImportant.PalindromicSubstring;

//Problem: https://leetcode.com/problems/palindromic-substrings/
//Time complexity: O(n^2)
//Space complexity: O(n)

public class FindNumberOfPalindromicSubstrings {
    public static void main(String[] args) {
//        String s = "abc";
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += findAllPalindromes(s, i, i + 1);
            count += findAllPalindromes(s, i, i);
        }
        return count;
    }

    static int findAllPalindromes(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            count++;
        }
        return count;
    }
}
