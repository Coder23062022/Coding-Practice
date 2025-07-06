package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem: https://leetcode.com/problems/combination-sum-ii/
//Video source: https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11&ab_channel=takeUforward
//Time Complexity: O(2^n * k)
//Space Complexity: O(k * x), k is the average length of combination and x is the no. of combinations

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {1, 1, 1, 2, 2}; //{10, 1, 2, 7, 6, 1, 5};
        int target = 4; //8;
        System.out.println(combinationSum2(candidates, target));
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    static void findCombination(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            if (arr[i] <= target) {
                ds.add(arr[i]);
                findCombination(i + 1, arr, target - arr[i], result, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    static void findCombinationMethod2(int i, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        //Base case
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        if (i < arr.length && arr[i] <= target) {
            //include
            ds.add(arr[i]);
            findCombination(i + 1, arr, target - arr[i], result, ds);

            //backtrack
            ds.remove(ds.size() - 1);

            //exclude
            int index = i + 1;
            while (index < arr.length && arr[index] == arr[index - 1]) index++;
            findCombination(index, arr, target, result, ds);
        }
    }
}