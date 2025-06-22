package Krish.src.Greedy;

//Problem: https://leetcode.com/problems/jump-game/
//Video source: https://www.youtube.com/watch?v=tZAa_jJ3SwQ&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {2, 1, 0, 3, 2};
        System.out.println(canJump(nums));
    }

    static boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int maxIndex = 0; //maxIndex means the farthest index you can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) return false; //Because it's not possible to reach an index beyond maxIndex
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }
}

//Note: In the given array, if 0 is not there then it will always return true.
//Only catch here is that if 0 is there, then it may or may not return true.