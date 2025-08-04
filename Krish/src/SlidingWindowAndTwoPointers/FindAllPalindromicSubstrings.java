package Krish.src.SlidingWindowAndTwoPointers;

import java.util.HashSet;
import java.util.Set;

//Time complexity: O(n^2)

public class FindAllPalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aabcdcbaxyx";
        // System.out.println(findAllPalindromesUsingBruteForceApproach(s)); // Time complexity: O(n^3)
        System.out.println(findAllPalindromesUsingCenter(s));
    }

    static Set<String> findAllPalindromesUsingCenter(String input) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            palindromes.addAll(findPalindromes(input, i, i + 1));
            palindromes.addAll(findPalindromes(input, i, i));
        }
        return palindromes;
    }

    static Set<String> findPalindromes(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result;
    }

    /*static Set<String> findAllPalindromesUsingBruteForceApproach(String s) {
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)))
                    hs.add(s.substring(i, j));
            }
        }
        return hs;
    }

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }*/
}