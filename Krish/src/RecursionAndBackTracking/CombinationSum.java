package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/combination-sum/
//Video source: https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=10&ab_channel=takeUforward
//Time Complexity: O(2^t * k) where t is the target, k is the average length
//Space Complexity: O(k*x), k is the average length and x is the no. of combinations

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    static void findCombinations(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index] <= target) {
            ds.add(arr[index]);
            findCombinations(index, arr, target - arr[index], result, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(index + 1, arr, target, result, ds);
    }
}