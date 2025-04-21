package Krish.src.SlidingWindow;

//Problem: https://leetcode.com/problems/minimum-size-subarray-sum/description/
//Video source: https://www.youtube.com/watch?v=aYqYMIqZx5s
//Time complexity: O(n)
//Space complexity: O(1)

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    static int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) return 1;
        int l = 0, r = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (r < nums.length) {
            sum = sum + nums[r];
            while (sum >= target) {
                minLength = Math.min(minLength, r - l + 1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}