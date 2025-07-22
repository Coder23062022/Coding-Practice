package Krish.src.DynamicProgramming.DpOn1D;

import java.util.Scanner;

//Problem: https://leetcode.com/problems/climbing-stairs
//Video source: https://www.youtube.com/watch?v=mLfjzJsN8us&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the number of stairs to climb:");
        int input = sc.nextInt();

        //If the input is 1, then there will be 1 way to achieve that. (1)
        //If the input is 2, then there will be 2 ways to achieve that. (1+1) or (2)
        //If the input is 3, then there will be 3 ways to achieve that. (1+1+1) or (1+2) or (2+1)
        //If the input is 4, then there will be 5 ways to achieve that. (1+1+1+1) or (2+2) or (1+2+1) or (1+1+2) or (2+1+1)
        //If the input is 5, then there will be 8 ways to achieve that. (2+2+1) or (2+1+2) or (1+2+2) or (1+1+1+1+1) and so on.
        //So basically, here if the number of ways to climb stairs is f(n), then f(n) = f(n-1) + f(n-2) which represents a Fibonacci series.
        System.out.println("Number of ways to climb the stairs is: " + climbStairs(input));
    }

    static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int i = 1, j = 1, temp = 0;
        for (int k = 2; k <= n; k++) {
            temp = i + j;
            i = j;
            j = temp;
        }
        return temp;
    }
}