package Krish.src.DynamicProgramming.DpOn1D;

import java.util.Arrays;
import java.util.Scanner;

//Problem: https://leetcode.com/problems/fibonacci-number/
//Video source: https://www.youtube.com/watch?v=tyB0ztf0DNY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=2&ab_channel=takeUforward

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Enter number upto which Fibonacci series to print: ");
        int number = new Scanner(System.in).nextInt();
        //Printing Fibonacci series up to number
        System.out.println("Fibonacci series upto " + number + " numbers : ");
        for (int i = 0; i <= number; i++) {
            System.out.print(fibonacciWithRecursion(i) + " ");
        }
        System.out.println();
        System.out.println(fibonacciWithRecursion(number));
        System.out.println(fibonacciWithMemoization(number));
        System.out.println(fibonacciWithTabulation(number));
        System.out.println(fibonacciWithSpaceOptimization(number));
    }

    //TC: O(2^n), SC: O(n)
    static int fibonacciWithRecursion(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    //TC: O(n), SC: O(n) + O(n)
    static int fibonacciWithMemoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibonacciHelperWithMemoization(n, dp);
    }

    static int fibonacciHelperWithMemoization(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = fibonacciHelperWithMemoization(n - 1, dp) + fibonacciHelperWithMemoization(n - 2, dp);
        return dp[n];
    }

    //TC: O(n), SC: O(n)
    static int fibonacciWithTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //TC: O(n), SC: O(1)
    static int fibonacciWithSpaceOptimization(int n) {
        int prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}