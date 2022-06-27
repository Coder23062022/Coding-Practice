package src.DynamicProgramming;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change-2/
// Time complexity of this function: O(mn)
// Space Complexity of this function: O(n)

public class CoinChangeNumberOfWays {
    static long countWays(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int i = 0; i < coins.length; i++)
            for (int j = coins[i]; j <= amount; j++)
                arr[j] += arr[j - coins[i]];
        return arr[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        System.out.println(countWays(coins, amount));
    }
}