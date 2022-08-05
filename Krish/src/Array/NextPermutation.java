package src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/next-permutation/
//Video source: https://www.youtube.com/watch?v=IhsUbEMfIbY&ab_channel=AlgorithmsMadeEasy
//Time complexity: O(n)
//Space complexity: O(1)

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //1. Find the point of change.
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            //2. Find the number of substitution.
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //3. Swap a[i] and a[j]
            swap(nums, i, j);
        }
        //4. Reverse the remaining array after substitution point.
        reverse(nums, i + 1, nums.length - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
