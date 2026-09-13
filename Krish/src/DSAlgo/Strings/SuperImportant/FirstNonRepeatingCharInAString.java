package Krish.src.DSAlgo.Strings.SuperImportant;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
//Video source: https://www.youtube.com/watch?v=sqyCBvEQN9c&ab_channel=ShradhaKhapra
//Time complexity: O(n)
//Space complexity: O(n)

public class FirstNonRepeatingCharInAString {
    static void main() {
        String str1 = "abcaabbdce";
        String str2 = "geeksforgeeks";
        System.out.println(firstNonRepeatingCharInAStringMeth1(str1));
//        System.out.println(firstNonRepeatingCharInAStringMeth2(str2));
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    static int firstNonRepeatingCharInAStringMeth1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    //Time complexity: O(n^2) as indexOf takes O(n) time and for each character we have to find first and last index.
    //Space complexity: O(1)
    static char firstNonRepeatingCharInAStringMeth2(String s) {
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