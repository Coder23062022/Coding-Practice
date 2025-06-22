package Krish.src.Greedy;

//Problem: https://leetcode.com/problems/jump-game-ii/
//Video source: https://www.youtube.com/watch?v=7SBVnw7GSTk&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    static int jump(int[] nums) {
        int jumps = 0, l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = 0;

            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}