package src.Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharInAString {
    public static void main(String[] args) {
        String str1 = "abcaabbdce";
        String str2 = "geeksforgeeks";
        System.out.println(firstNonRepeatingCharInAStringMeth1(str1));
        System.out.println(firstNonRepeatingCharInAStringMeth2(str2));
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    private static char firstNonRepeatingCharInAStringMeth1(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return '_';
    }

    //Time complexity: O(n^2) as indexOf takes O(n) time and for each character we have to find first and last index.
    //Space complexity: O(1)
    private static char firstNonRepeatingCharInAStringMeth2(String s) {
        for (int i = 0; i < s.length(); i++) {
            // If the first index of the character is equal to the last index of the
            // character, then there is only one occurrence of that character in the string.
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '_';
    }
}