package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/house-robber-ii/description/
//Video Source: https://www.youtube.com/watch?v=rWAJCfYYOvM&ab_channel=NeetCode
//Time complexity: O(n)
//Space complexity: O(1)
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] a = {2, 7, 9, 5, 6, 6};
        System.out.println(rob(a));
    }

    static int rob(int[] nums) {
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