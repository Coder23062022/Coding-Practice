package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/subsets-ii/
//Video source: https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13&ab_channel=takeUforward
//Time Complexity: O(2^n * k), where O(2^n) for generating every subset and O(k) to insert every subset in another data structure if the average length of every subset is k.
//Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O(n) if n is the depth of the recursion tree.

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithoutDup(nums));
    }

    static List<List<Integer>> subsetsWithoutDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subset(0, nums, result, new ArrayList<>());
        return result;
    }

    static void subset(int index, int[] nums, List<List<Integer>> result, List<Integer> ds) {
        result.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            subset(i + 1, nums, result, ds);
            ds.remove(ds.size() - 1);
        }
    }
}