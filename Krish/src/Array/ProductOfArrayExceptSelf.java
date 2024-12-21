package Krish.src.Array;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/product-of-array-except-self/
//Source video: https://www.youtube.com/watch?v=tSRFtR3pv74&ab_channel=NickWhite
//Time complexity: O(n), Space complexity: O(1)

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelfWithSpaceOptimization(nums)));
    }

//index	  =                  0	1	2	4		Multiply direction
//nums(given array)	=        1	2	3	4
//result=result*nums[i] =    1	1	2	6		→
//R=R*nums[i]	    =       24	12	4	1		←
//final result=R*result	=   24	12	8	6		→

    static int[] productExceptSelfWithSpaceOptimization(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * R;
            R = R * nums[i];
        }
        return result;
    }

    static int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] result = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        R[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}