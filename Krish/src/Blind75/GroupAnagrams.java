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
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String originalString : strs) {
            char[] ca = originalString.toCharArray();
            Arrays.sort(ca); //Sort the string lexicographically.
            String sortedString = String.valueOf(ca);

            if (!map.containsKey(sortedString))
                //If map doesn't contain the sorted string, then create a new list for that sorted string as the value of the map.
                //For first case - key: aet, value: {}
                map.put(sortedString, new ArrayList<>());

            //Adding the original string to the existing list associated with the same sorted string.
            //For first case - key: aet, value: {eat}
            map.get(sortedString).add(originalString);
        }
        return new ArrayList<>(map.values());
    }
}