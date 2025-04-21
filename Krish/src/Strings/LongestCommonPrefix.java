package Krish.src.Strings;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/longest-common-prefix/
//Solution: https://www.geeksforgeeks.org/longest-common-prefix-using-sorting/
//Time complexity: O(nlogn + n)
//Space complexity: O(1)

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"flight", "flight1"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        //To find the longest common prefix, we only need to compare the first and last strings.
        //Because any common prefix between these two will also be a prefix for all the strings in between.
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLength = Math.min(first.length(), last.length());

        int i = 0;
        while (i < minLength && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }
}