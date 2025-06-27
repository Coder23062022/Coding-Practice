package Krish.src.SearchingAlgo;

import java.util.Scanner;

//Problem: https://leetcode.com/problems/sqrtx/
//Video source: https://www.youtube.com/watch?v=Bsv3FPUX_BA&ab_channel=takeUforward
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class FindSquareRoot {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give an input:");
        int input = sc.nextInt();
        System.out.println("Square root of " + input + " is: " + findSquareRoot(input));
    }

    static int findSquareRoot(int x) {
        int low = 0, high = x;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        //The flow will come here only when the input is not a perfect square. In that case return the last 'high' value.
        return high;
    }
}