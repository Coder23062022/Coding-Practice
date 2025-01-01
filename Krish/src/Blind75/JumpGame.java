package Krish.src.Blind75;

//Problem: https://leetcode.com/problems/jump-game/
//Video source: https://www.youtube.com/watch?v=tZAa_jJ3SwQ&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {1, 0, 2};
        System.out.println(canJump(nums));
    }

    static boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}