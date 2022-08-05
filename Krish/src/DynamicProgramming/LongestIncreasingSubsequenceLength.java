package src.DynamicProgramming;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/longest-increasing-subsequence/
//Video source: https://www.youtube.com/watch?v=CE2b_-XfVDk&t=276s&ab_channel=TusharRoy-CodingMadeSimple
//Time complexity: O(n^2)
//Space complexity: O(n)

public class LongestIncreasingSubsequenceLength {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    static int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, res[i]);
        return max;
    }
}
