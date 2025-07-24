package Krish.src.DynamicProgramming;

//Problem: https://leetcode.com/problems/frog-jump/
//Video source: https://www.youtube.com/watch?v=l9E-ZcbFhDg&t=1s&ab_channel=codestorywithMIK

import java.util.HashMap;
import java.util.Map;

public class FrogJumpLeetCode {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCrossWithRecursion(stones));
        System.out.println(canCrossWithMemoization(stones));
    }

    //TC: O(3^n), SC: O(n)
    static boolean canCrossWithRecursion(int[] stones) {
        if (stones[1] != 1) return false;
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return canCrossHelperWithRecursion(stones, n, map, 0, 0);
    }

    static boolean canCrossHelperWithRecursion(int[] stones, int n, Map<Integer, Integer> map, int curr_stone_idx, int prevJump) {
        if (curr_stone_idx == n - 1) return true;
        boolean res = false;
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStone = stones[curr_stone_idx] + nextJump;
                if (map.containsKey(nextStone)) {
                    res = res || canCrossHelperWithRecursion(stones, n, map, map.get(nextStone), nextJump);
                }
            }
        }
        return res;
    }

    //TC: O(n), SC: O(n) + O(n)
    static boolean canCrossWithMemoization(int[] stones) {
        if (stones[1] != 1) return false;
        int n = stones.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        Boolean[][] dp = new Boolean[n][n];
        return canCrossHelperWithMemoization(stones, n, map, 0, 0, dp);
    }

    static boolean canCrossHelperWithMemoization(int[] stones, int n, Map<Integer, Integer> map, int curr_stone_idx, int prevJump, Boolean[][] dp) {
        if (curr_stone_idx == n - 1) return true;

        if (dp[curr_stone_idx][prevJump] != null) return dp[curr_stone_idx][prevJump];

        boolean res = false;
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0) {
                int nextStone = stones[curr_stone_idx] + nextJump;
                if (map.containsKey(nextStone)) {
                    res = res || canCrossHelperWithMemoization(stones, n, map, map.get(nextStone), nextJump, dp);
                }
            }
        }
        return dp[curr_stone_idx][prevJump] = res;
    }
}