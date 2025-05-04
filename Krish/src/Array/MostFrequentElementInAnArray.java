package Krish.src.Array;

import java.util.HashMap;
import java.util.Map;

//Problem: https://www.geeksforgeeks.org/problems/most-frequent-element-in-an-array/1
//Reference doc: https://www.geeksforgeeks.org/frequent-element-array/
//Time complexity: O(n)
//Space complexity: O(n)

public class MostFrequentElementInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 4, 1};
        System.out.println(mostFreqEle(arr));
    }

    static int mostFreqEle(int[] arr) {
        int n = arr.length;
        int res = 0;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int j : arr) freq.put(j, freq.getOrDefault(j, 0) + 1);

        int max = 0;
        for (var entry : freq.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (max < val || (max == val && key > res)) {
                res = key;
                max = val;
            }
        }
        return res;
    }
}