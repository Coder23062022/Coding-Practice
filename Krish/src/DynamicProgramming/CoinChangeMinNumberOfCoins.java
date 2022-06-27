package src.DynamicProgramming;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change/

public class CoinChangeMinNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println("Minimum number of coins to make the amount is: " + coinChange(coins, 11));
    }

    static int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (arr[j - coins[i]] != Integer.MAX_VALUE) {
                    arr[j] = Math.min(arr[j], arr[j - coins[i]] + 1);
                }
            }
        }
        return arr[arr.length - 1] == Integer.MAX_VALUE ? -1 : arr[arr.length - 1];
    }
}
