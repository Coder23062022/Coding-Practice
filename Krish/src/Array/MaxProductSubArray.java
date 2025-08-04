package Krish.src.Array;

//Problem: https://leetcode.com/problems/maximum-product-subarray/
//Video source: https://www.youtube.com/watch?v=hnswaLJvr6g
//Time complexity: O(n)
//Space complexity: O(1)

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
//        int[] nums = {3, 2, -1, 4, 0, -6, 3, -2, 6};
        System.out.println(maxProduct(nums));
    }

    static int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1, result = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }

    static int maxProductSolution2(int[] nums) {
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