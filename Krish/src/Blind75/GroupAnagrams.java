package Krish.src.Blind75;

import java.util.*;

//Problem: https://leetcode.com/problems/group-anagrams/description/
//Time complexity: O(m * nlogn)
//Space complexity: O(n)

public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String originalString : strs) {
            char[] ca = originalString.toCharArray();
            Arrays.sort(ca); //Sort the string lexicographically.
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