package src.DynamicProgramming;

//Problem: https://leetcode.com/problems/maximum-product-subarray/
//Time complexity: O(n)

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    static int maxProduct(int[] nums) {
        int max = nums[0], curMax = nums[0], curMin = nums[0], temp;
        for (int i = 1; i < nums.length; i++) {
            temp = curMax;
            curMax = Math.max(nums[i], Math.max(nums[i] * curMax, nums[i] * curMin));
            curMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * curMin));
            max = Math.max(max, curMax);
        }
        return max;
    }
}
