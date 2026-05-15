package Krish.src.DSAlgo.Strings;

//Problem: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
//Solution: https://www.youtube.com/watch?v=OWaZ6AosS30
//Time complexity: O((n - m) × m), where n is the haystack length and m is the needle length
//Explanation: Substring and equals comparison both take O(m) time and the outer loop takes O(n - m) time
//Space complexity: O(1)

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}