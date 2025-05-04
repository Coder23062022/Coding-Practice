package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/product-of-array-except-self/
//Source video: https://www.youtube.com/watch?v=TW2m8m_FNJE&ab_channel=ApnaCollege
//Time complexity: O(2n)
//Space complexity: O(1)

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelfWithSpaceOptimization(nums)));
    }

    static int[] productExceptSelfWithSpaceOptimization(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            result[i] = result[i] * suffix;
        }
        return result;
    }

    //Time complexity: O(3n)
    //Space complexity: O(2n)
    static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}