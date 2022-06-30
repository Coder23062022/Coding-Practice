package src.Greedy;

//Problem: https://leetcode.com/problems/jump-game/

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {1, 0, 2};
        System.out.println(canJump(nums));
    }

    static boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= index)
                index = i;
        }
        return index == 0;
    }
}
