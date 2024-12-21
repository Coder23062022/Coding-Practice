package Krish.src.Array;

//Problem: https://leetcode.com/problems/missing-number/
//Time complexity: O(n)
//Space complexity: O(1)

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    //The missing number is: (sum of all numbers in 0 to nums.length range) - (sum of all numbers in nums array)
    static int missingNumber(int[] nums) {
        int sum = 0;

        //Sum of all numbers in nums array.
        for (int i : nums) {
            sum += i;
        }

        //Sum of all numbers in 0 to nums.length range is AP series sum i.e. n*(n-1)/2.
        //Here, n = nums.length + 1 as one number is missing.
        int rangeSum = (nums.length + 1) * ((nums.length + 1) - 1) / 2;

        return rangeSum - sum;
    }
}