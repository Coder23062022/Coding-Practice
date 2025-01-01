package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/combination-sum-iv/description/
//Video source: https://www.youtube.com/watch?v=dw2nMCxG0ik&ab_channel=NeetCode
//Time complexity: O(n * target), n is the length of the array 'nums'
//Space complexity: O(target)

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 3;
        System.out.println(combinationSum4(nums, target));
    }

    static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}