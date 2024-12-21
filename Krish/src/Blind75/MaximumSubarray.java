package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/maximum-subarray/
//Solved by 'Kadane's Algorithm'.
//Video reference: https://www.youtube.com/watch?v=HCL4_bOd3-4&ab_channel=AnujBhaiya

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-1};
//        int[] nums = {-3,-2,-2,-3};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        if (nums.length == 0) return -1;
        //Here if you initialize maxSum as -1, then it won't work if all elements are negative in the array and if you initialize
        //maxSum as 0 then it won't work if array contains only -1. That's why initialize with Integer.MIN_VALUE.
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum = currSum + num;
            maxSum = Math.max(currSum, maxSum);
            //If any negative number will come, then we have to ignore that because it will reduce the sum value.
            //So, till now whatever the maximum sum we can get that is already there in maxSum and currSum we are setting
            //it to 0 again to start with a new sub-array.
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}