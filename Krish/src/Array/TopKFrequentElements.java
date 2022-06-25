package src.Array;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequentElements(nums, k);
        System.out.println("Top " + k + " Frequent Elements are:");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static int[] topKFrequentElements(int[] nums, int k) {
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