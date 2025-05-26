package Krish.src.Array;

import java.util.*;

//Problem: https://leetcode.com/problems/sort-characters-by-frequency/
//Video source: https://www.youtube.com/watch?v=WYjTKQEWbVQ&t=1274s&ab_channel=AryanMittal
//Time complexity: O(n + k), n is the size of freqCharMap and k is the total characters
//Space complexity: O(n)

public class SortCharactersByFrequency {
    public static void main(String[] args) {
//        String s = "tree";
        String s = "tmqreqqemm";
        System.out.println(frequencySort(s));
    }

    static String frequencySort(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        Map<Integer, List<Character>> freqCharMap = new TreeMap<>(Collections.reverseOrder());
        StringBuilder res = new StringBuilder();

        //Calculate the frequency of each character O(n)
        //t->1, r->1, e->2, q->3, m->3
        for (char a : s.toCharArray())
            charFreqMap.put(a, charFreqMap.getOrDefault(a, 0) + 1);

        //Form the freqCharMap map: O(n)
        //Key: values from charFreqMap map, Value: all the keys from charFreqMap map having that value
        //2->{e}, 1->{t,r}, 3->{q, m} (As it's a reverse ordered tree map)
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            if (!freqCharMap.containsKey(entry.getValue())) {
                freqCharMap.put(entry.getValue(), new ArrayList<>());
            }
            freqCharMap.get(entry.getValue()).add(entry.getKey());
        }

        //Iterate over freqCharMap map, append each character 'key' number of times in the result
        //freqCharMap.size() (n) + Total number of characters(k)
        for (Map.Entry<Integer, List<Character>> entry : freqCharMap.entrySet()) {
            int freq = entry.getKey();
            List<Character> chars = entry.getValue();
            for (char c : chars) {
                res.append(String.valueOf(c).repeat(freq)); //Using Java11 repeat() function
//                for (int i = 0; i < freq; i++) {
//                    res.append(c);
//                }
            }
        }
        return res.toString();
    }
}