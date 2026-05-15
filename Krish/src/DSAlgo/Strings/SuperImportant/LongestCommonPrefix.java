package Krish.src.DSAlgo.Strings.SuperImportant;

//Problem: https://leetcode.com/problems/longest-common-prefix/
//Solution: https://www.youtube.com/watch?v=0sWShKIJoo4
//Time complexity: O(n * m), where n is the number of strings and m is the length of longest string.
//Space complexity: O(m)

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i); // Current character (must be the same in all strings to be a part of result)

            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return res.toString();
                }
            }

            res.append(ch);
        }
        return res.toString();
    }
}