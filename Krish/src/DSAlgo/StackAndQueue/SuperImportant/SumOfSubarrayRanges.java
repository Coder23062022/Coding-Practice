package Krish.src.DSAlgo.StackAndQueue.SuperImportant;

import static Krish.src.DSAlgo.StackAndQueue.SuperImportant.SumOfSubarrayMaximums.sumSubarrayMax;
import static Krish.src.DSAlgo.StackAndQueue.SuperImportant.SumOfSubarrayMinimums.sumSubarrayMins;

//Problem: https://leetcode.com/problems/sum-of-subarray-ranges
//video source: https://www.youtube.com/watch?v=gIrMptNPf5M
//Time complexity: O(10n) ≈ O(n)
//Space complexity: O(10n) ≈ O(n)

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums));
    }

    static long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
}