package Krish.src.Strings;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
//Video source: https://www.youtube.com/watch?v=sqyCBvEQN9c&ab_channel=ShradhaKhapra
//Time complexity: O(n)
//Space complexity: O(n)

public class FirstNonRepeatingCharInAString {
    static class Pair {
        Integer count;
        Integer index;

        Pair(Integer count, Integer index) {
            this.count = count;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        String str1 = "abcaabbdce";
        String str2 = "geeksforgeeks";
        System.out.println(firstNonRepeatingCharInAStringMeth1(str1));
//        System.out.println(firstNonRepeatingCharInAStringMeth2(str2));
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
    static int firstNonRepeatingCharInAStringMeth1(String s) {
        Map<Character, Pair> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), new Pair(hm.get(s.charAt(i)).count + 1, i));
            } else {
                hm.put(s.charAt(i), new Pair(1, i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hm.get(s.charAt(i)).count == 1)
                return hm.get(s.charAt(i)).index;
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