package src.Strings;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    // Sliding window problem
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "abcbcad";

        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++; // The right pointer is expanding the window here.
                max = Math.max(hashSet.size(), max); // Hashset size is the total number of unique characters in the hashset against the current max.
            } else {
                hashSet.remove(s.charAt(left)); //Popping out the beginning character from the hashset.
                left++;
            }
        }
        System.out.println("Length of the longest substring without repeating characters is: " + max);
        //System.out.println(hashSet);
    }
}