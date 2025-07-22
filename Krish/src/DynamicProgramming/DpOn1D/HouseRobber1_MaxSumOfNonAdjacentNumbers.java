package Krish.src.DynamicProgramming.DpOn1D;

//Problem: https://leetcode.com/problems/house-robber
//Video Source: https://www.youtube.com/watch?v=GrMBfJNk_NY&t=1821s&ab_channel=takeUforward
//Video Source: https://www.youtube.com/watch?v=UtGtF6nc35g&ab_channel=TusharRoy-CodingMadeSimple

import java.util.Arrays;

public class HouseRobber1_MaxSumOfNonAdjacentNumbers {
    public static void main(String[] args) {
        int[] a = {2, 7, 9, 5, 6, 6};
        System.out.println(houseRobberWithRecursion(a));
        System.out.println(houseRobberWithMemoization(a));
        System.out.println(houseRobberWithTabulation(a));
        System.out.println(houseRobberWithSpaceOptimization(a));
        System.out.println(houseRobberGreedy(a));
    }

    //TC: O(2^n), SC: O(n) <This will give TLE>
    static int houseRobberWithRecursion(int[] nums) {
        int n = nums.length;
        return houseRobberHelperWithRecursion(nums, n - 1);
    }

    static int houseRobberHelperWithRecursion(int[] nums, int index) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        int pick = nums[index] + houseRobberHelperWithRecursion(nums, index - 2);
        int notPick = houseRobberHelperWithRecursion(nums, index - 1);
        return Math.max(pick, notPick);
    }

    //TC: O(n), SC: O(n) + O(n)
    static int houseRobberWithMemoization(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return houseRobberHelperWithMemoization(nums, n - 1, dp);
    }

    static int houseRobberHelperWithMemoization(int[] nums, int index, int[] dp) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + houseRobberHelperWithMemoization(nums, index - 2, dp);
        int notPick = houseRobberHelperWithMemoization(nums, index - 1, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    //TC: O(n), SC: O(n)
    static int houseRobberWithTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    //TC: O(n), SC: O(1)
    static int houseRobberWithSpaceOptimization(int[] nums) {
        int n = nums.length;
        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    //TC: O(n), SC: O(1)
    static int houseRobberGreedy(int[] a) {
        int excl = 0, incl = 0;
        for (int x : a) {
            int temp = incl; //Storing the old inclusive to temp.
            incl = Math.max(incl, x + excl); //Formula to calculate the new inclusive.
            excl = temp; //New exclusive will be the old inclusive.
        }
        return incl;
    }
}