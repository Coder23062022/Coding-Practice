package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/fruit-into-baskets/
//Video source: https://www.youtube.com/watch?v=e3bs0uA1NhQ&t=3s&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1), because map size will always be 2

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(totalFruit(fruits));
    }

    static int totalFruit(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        while (r < fruits.length) {
            freqMap.put(fruits[r], freqMap.getOrDefault(fruits[r], 0) + 1);
            if (freqMap.size() > 2) {
                freqMap.put(fruits[l], freqMap.get(fruits[l]) - 1);
                if (freqMap.get(fruits[l]) == 0) freqMap.remove(fruits[l]);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}