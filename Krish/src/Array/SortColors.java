package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/sort-colors/
//Video source: https://www.youtube.com/watch?v=sEQk8xgjx64
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
        int l = 0, m = 0, r = nums.length - 1;

        while (m <= r) {
            //If the value is 0, then swap the left and middle pointer and increment the left and middle pointer's value.
            if (nums[m] == 0) {
                swap(l, m, nums);
                l++;
                m++;
            }
            //If the value is 2, then swap the right and middle pointer's value and decrement the right pointer.
            //But don't increment the middle pointer in this case.
            else if (nums[m] == 2) {
                swap(m, r, nums);
                r--;
            }
            //If the value is 1, then only increment the middle pointer as 1 should be in the middle position.
            else {
                m++;
            }
        }
    }

    static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
