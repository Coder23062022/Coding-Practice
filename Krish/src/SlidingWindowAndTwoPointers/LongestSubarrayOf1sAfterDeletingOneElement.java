package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
//Similar problem: https://leetcode.com/problems/max-consecutive-ones-iii/
//Video source: https://www.youtube.com/watch?v=3E4JBHSLpYk&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    static int longestSubarray(int[] nums) {
        int l = 0, r = 0, maxLen = 0, noOfZeros = 0;
        while (r < nums.length) {
            if (nums[r] == 0) noOfZeros++;
            if (noOfZeros > 1) {
                if (nums[l] == 0) noOfZeros--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen - 1;
    }
}