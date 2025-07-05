package Krish.src.Strings;

import java.util.HashMap;
import java.util.Map;

//Problem: https://leetcode.com/problems/roman-to-integer/
//Video source: https://www.youtube.com/watch?v=3jdxYj3DD98&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(1), as we are using a map of constant size, so the space complexity becomes O(1).

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get(s.charAt(i + 1)) > romanMap.get(s.charAt(i))) {
                res += romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
                i++;
            } else {
                res += romanMap.get(s.charAt(i));
            }
        }
        return res;
    }
}