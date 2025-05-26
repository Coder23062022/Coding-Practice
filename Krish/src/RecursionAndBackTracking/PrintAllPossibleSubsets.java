package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/subsets/
//Video source: https://www.youtube.com/watch?v=REOH22Xwdkk
//Video source: https://www.youtube.com/watch?v=V0IgCltYgg4&ab_channel=CodeHelp-byBabbar
//Time complexity: O(n * 2^n), where n is the size of the given array.
//Space complexity: O(n * 2^n)

public class PrintAllPossibleSubsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        subsets(nums, output, 0, result);
        return result;
    }

    static void subsets(int[] nums, List<Integer> output, int index, List<List<Integer>> result) {
        //If index == input.length(), then we are at the last level of recursion tree.
        if (index == nums.length) {
            //Explanation why we are doing new ArrayList<>:
            //https://leetcode.com/problems/subsets/discuss/1766675/Java-Intuition-of-Approach-or-Backtracking/1265297
            result.add(new ArrayList<>(output));
            return;
        }

        //include(pick)
        output.add(nums[index]);
        subsets(nums, output, index + 1, result);
        output.remove(output.size() - 1);
        //exclude(not pick)
        subsets(nums, output, index + 1, result);
    }
}