package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
//Video source: https://www.youtube.com/watch?v=3E4JBHSLpYk&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0, noOfZeros = 0;
        while (r < nums.length) {
            if (nums[r] == 0) noOfZeros++;
            if (noOfZeros > k) {
                if (nums[l] == 0) noOfZeros--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}