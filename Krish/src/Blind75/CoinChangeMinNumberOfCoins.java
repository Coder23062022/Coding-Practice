package Krish.src.Blind75;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/coin-change/
//Video source: https://www.youtube.com/watch?v=H9bfqozjoqs&ab_channel=NeetCode
//Time complexity: O(amount * number of coins)
//Space complexity: O(amount)

public class CoinChangeMinNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {1, 3, 4, 5}; //{1, 2, 5}
        int amount = 7; //11
        System.out.println("Minimum number of coins to make the amount is: " + coinChangeMethod1(coins, amount));
    }

    static int coinChangeMethod1(int[] coins, int amount) {
        int[] arr = new int[amount + 1]; //array size should be (amount + 1) as array starts from 0th index.
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    arr[a] = Math.min(arr[a], 1 + arr[a - c]);
                }
            }
        }
        return arr[amount] == Integer.MAX_VALUE ? -1 : arr[amount];
    }

    static int coinChangeMethod2(int[] coins, int amount) {
        int[] arr = new int[amount + 1]; //array size should be (amount + 1) as array starts from 0th index.
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                if (arr[j - c] != Integer.MAX_VALUE) {
                    arr[j] = Math.min(arr[j], arr[j - c] + 1);
                }
            }
        }
        return arr[arr.length - 1] == Integer.MAX_VALUE ? -1 : arr[arr.length - 1];
    }
}