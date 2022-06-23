package Strings;

//Time Complexity: O(n^2) and Space complexity: O(n)

import java.util.*;

public class AllPalindromicSubstringsIncludingTheLongestOne {
    static int maxLength = 0;

    public static void main(String[] args) {
//        String str = "babad";
        String str = "racecar";

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            findAllPalindromicSubStrings(str, i, i, set); // odd length
            findAllPalindromicSubStrings(str, i, i + 1, set); // even length
        }
        System.out.println("All palindromic substrings are:" + set);
        System.out.println("Longest Palindromic Substrings are:");
        for (String s : set) {
            if (s.length() == maxLength) {
                System.out.println(s);
            }
        }
        System.out.println("Longest Palindromic Substring's length is: " + maxLength);
    }

    //Expanding from middle.
    static void findAllPalindromicSubStrings(String s, int low, int high, Set<String> hs) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            hs.add(s.substring(low, high + 1));
            int subStringLength = s.substring(low, high + 1).length();
            maxLength = Math.max(maxLength, subStringLength);
            low--;
            high++;
        }
    }
}