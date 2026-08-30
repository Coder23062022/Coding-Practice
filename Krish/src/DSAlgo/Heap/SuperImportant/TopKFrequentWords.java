package Krish.src.DSAlgo.Heap.SuperImportant;

import java.util.*;

//Problem: https://leetcode.com/problems/top-k-frequent-words
//Similar problem: Top k frequent elements
//Time complexity: O(n + klogk)
//Space complexity: O(d), d is the count of distinct words in the array

public class TopKFrequentWords {
    static void main() {
        //Input 1
        String[] words1 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k1 = 4;

        //Input 2
        String[] words2 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k2 = 1;

        System.out.println(topKFrequentWords(words1, k1));
        System.out.println(topKFrequentWords(words2, k2));
    }

    static class Pair {
        int freq;
        String word;

        Pair(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }
    }

    static List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return Integer.compare(a.freq, b.freq); //lowest frequency is at the top of the PriorityQueue.
            }

            //If frequencies are equal, then lexicographically larger word is at the top of the PriorityQueue.
            //So for equal frequencies: lexicographically larger word comes out first.
            //Example: 'i' and 'love' both have freq 2 in words2 array, so 'love' will be at the top of pq instead of 'i' as we
            //are doing reverse lexicographical ordering. If we do a.word.compareTo(b.word), then 'i' will be at the top of pq which we don't want here.
            return b.word.compareTo(a.word);
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getValue(), entry.getKey()));
            if (pq.size() > k) pq.poll();
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }

        //As this pq stores the lowest frequency word at the top, so the lowest freq word is added to the 'res' list first.
        //So, we have to reverse this list so that the highest freq word comes at the top of the list.
        //Basically to print the list as descending order of freq.
        Collections.reverse(res);
        return res;
    }
}
