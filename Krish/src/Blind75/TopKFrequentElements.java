package Krish.src.Blind75;

import java.util.*;

//Problem: https://leetcode.com/problems/top-k-frequent-elements/description/
//Video source: https://www.youtube.com/watch?v=YPTqKIgVk-k&ab_channel=NeetCode
//Solution: https://leetcode.com/problems/top-k-frequent-elements/solutions/5513122/video-2-solutions/
//Time complexity: O(n)
//Space complexity: O(n)

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3};
        int k = 2;
//        int[] result = topKFrequentElementsWithSorting(nums, k);
        int[] result = topKFrequentElementsWithoutSorting(nums, k);
        System.out.println("Top " + k + " Frequent Elements are:");
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] topKFrequentElementsWithoutSorting(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        } //Here counter map will be like: 1 - 3, 2 - 2, 3 - 1

        List<Integer>[] freqArray = new ArrayList[nums.length + 1];
        //First populate the freq array with blank list.
        for (int i = 0; i < freqArray.length; i++) {
            freqArray[i] = new ArrayList<>();
        }

        //Prepare the frequency array
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int frequency = entry.getValue();
            freqArray[frequency].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freqArray.length - 1; i >= 0; i--) {
            for (int num : freqArray[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }
        return new int[0];
    }

    static int[] topKFrequentElementsWithSorting(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
            //Here map will be like: 1 - 3, 2 - 2, 3 - 1
        }

        List<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list); //List will be: 1,2,3

        //Finding the kth last element in the sorted list so that all the elements in the map having that frequency or more than
        //that will come into the result.
        int min_freq = list.get(list.size() - k); //min_freq will be: list.get(3-2) = list.get(1) = 2

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            //All the elements in the map having min_freq or more than that will come into the result.
            if (entry.getValue() >= min_freq) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}