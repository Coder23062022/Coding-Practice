package Krish.src.Strings;

import java.util.ArrayList;
import java.util.*;

//Problem: https://leetcode.com/problems/group-anagrams
//Video source: https://www.youtube.com/watch?v=5BkDGXVXRA0

public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramsWithoutSorting(strs));
    }

    //Time complexity: O(n * k), where n is the number of words and k is the maximum length of a word
    //Space complexity: O(n * k)
    static List<List<String>> groupAnagramsWithoutSorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] frequencyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }

            String keyStr = String.valueOf(frequencyArr);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>(List.of(s)));
            } else {
                map.get(keyStr).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    //Time complexity: O(n * k * logk), where n is the number of words and k is the maximum length of a word
    //Space complexity: O(n * k)
    static List<List<String>> groupAnagramsWithSorting(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String originalString : strs) {
            char[] ca = originalString.toCharArray();
            Arrays.sort(ca);
            String sortedString = String.valueOf(ca);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>(List.of(originalString)));
            } else {
                map.get(sortedString).add(originalString);
            }
        }
        return new ArrayList<>(map.values());
    }
}