package src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/sort-colors/
//Video source: https://www.youtube.com/watch?v=4xbWSRZHqac&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(1)

public class SortColors {
    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {0, 1, 2, 1, 0, 2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, index = 0;

        while (index <= r) {
            //If the value is 0, then swap with the left pointer and increment the left pointer's value and the index.
            if (nums[index] == 0) {
                swap(index, l, nums);
                l++;
                index++;
            }
            //If the value is 2, then swap with the right pointer's value and decrement the right pointer.
            //But don't increment the index in this case.
            else if (nums[index] == 2) {
                swap(index, r, nums);
                r--;
            }
            //If the value is 1, then only increment the index.
            else {
                index++;
            }
        }
    }

    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
