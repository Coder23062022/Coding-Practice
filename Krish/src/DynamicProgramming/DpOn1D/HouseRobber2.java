package Krish.src.DynamicProgramming.DpOn1D;

//Problem: https://leetcode.com/problems/house-robber-ii
//Video Source: https://www.youtube.com/watch?v=3WaxQMELSkw&t=345s&ab_channel=takeUforward
//Video Source: https://www.youtube.com/watch?v=rWAJCfYYOvM&ab_channel=NeetCode

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(houseRobber2WithSpaceOptimization(nums));
        System.out.println(houseRobber2Greedy(nums));
    }

    //Same as house robber1 with only change is that removing first and last element as the array is circular
    //TC: O(n), SC: O(1)
    static int houseRobber2WithSpaceOptimization(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i] = nums[i];
            if (i != n - 1) temp2[i] = nums[i];
        }
        return Math.max(houseRobber1(temp1), houseRobber1(temp2));
    }

    static int houseRobber1(int[] nums) {
        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    //Run the HouseRobber1 solution twice. One time including the last element and excluding the first element.
    //Another time including the first element and excluding the last element.
    //TC: O(n), SC: O(1)
    static int houseRobber2Greedy(int[] nums) {
        if (nums.length == 1) return nums[0];

        int incl1 = 0, excl1 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = incl1;
            incl1 = Math.max(incl1, excl1 + nums[i]);
            excl1 = temp;
        }

        int incl2 = 0, excl2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = incl2;
            incl2 = Math.max(incl2, excl2 + nums[i]);
            excl2 = temp;
        }

        return Math.max(incl1, incl2);
    }
}