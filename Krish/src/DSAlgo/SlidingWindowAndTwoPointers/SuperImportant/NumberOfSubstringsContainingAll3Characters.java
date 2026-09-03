package Krish.src.DSAlgo.SlidingWindowAndTwoPointers.SuperImportant;

//Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
//Video source: https://www.youtube.com/watch?v=xtqN4qlgr8s
//Time complexity: O(n)
//Space complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAll3Characters {
    static void main() {
        String s = "bbacba"; //"abcabc";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsMethod2(s));
    }

    static int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) { //Can remove this condition also
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }
        return count;
    }

    static int numberOfSubstringsMethod2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() == 3) {
                count += s.length() - r;
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }

            r++;
        }
        return count;
    }
}