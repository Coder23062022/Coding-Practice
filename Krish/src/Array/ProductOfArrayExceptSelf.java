package src.Array;

import java.util.Arrays;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums
//except nums[i]. Time complexity: O(n)
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    //Source video: https://www.youtube.com/watch?v=tSRFtR3pv74&ab_channel=NickWhite
    static int[] productExceptSelf(int[] nums) {
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
}
