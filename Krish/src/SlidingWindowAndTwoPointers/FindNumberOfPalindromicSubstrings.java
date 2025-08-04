package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/palindromic-substrings/

public class FindNumberOfPalindromicSubstrings {
    public static void main(String[] args) {
//        String s = "abc";
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += findAllSubStrings(s, i, i + 1);
            count += findAllSubStrings(s, i, i);
        }
        return count;
    }

    static int findAllSubStrings(String s, int low, int high) {
        int count = 0;
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            count++;
        }
        return count;
    }
}
