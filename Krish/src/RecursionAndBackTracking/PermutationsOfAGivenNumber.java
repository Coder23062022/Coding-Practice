package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/permutations/
//Video source: https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=15&ab_channel=takeUforward
//Time Complexity: O(n! * n)
//Space Complexity: O(n!)

public class PermutationsOfAGivenNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        func(0, nums, res);
        return res;
    }

    static void func(int index, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) {
                ds.add(num);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            func(index + 1, nums, res);
            swap(nums, i, index);
        }
    }

    static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}