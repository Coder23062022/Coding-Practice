package Krish.src.SlidingWindow;

import java.util.HashSet;

//Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Time complexity: O(n)
//Space complexity: O(n)

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = "abcbcad";

        int left = 0, right = 0, max = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++; // The right pointer is expanding the window here.
                max = Math.max(hashSet.size(), max); // Hashset size is the total number of unique characters in the hashset against the current max.
            } else {
                //Removing characters from left pointer side until the character at right pointer becomes unique in hashset.
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println("Length of the longest substring without repeating characters is: " + max);
        //System.out.println(hashSet);
    }
}