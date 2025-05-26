package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/next-permutation/
//Video source: https://www.youtube.com/watch?v=-1cLK6PaLsQ&ab_channel=ApnaCollege
//Time complexity: O(n)
//Space complexity: O(1)

class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 2, 3, 6, 5, 4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        //Find the pivot (The largest index i such that nums[i] < nums[i+1])
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        //If pivot is still -1, then the given array is in descending order. In that case, just reverse the array.
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        //Find the first number from right which is greater than pivot and swap them.
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        //Reverse the portion of the array which is after the pivot.
        int l = pivot + 1, r = n - 1;
        reverse(nums, l, r);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}