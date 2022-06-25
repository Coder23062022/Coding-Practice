package src.GeneralProgram;

import java.util.Scanner;

public class ClimbingStairs {

    // You can either use 1 step or 2 steps to climb the stairs.

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the number of stairs to climb:");
        int input = sc.nextInt();

        //If the input is 1, then there will be 1 way to achieve that. (1)
        //If the input is 2, then there will be 2 ways to achieve that. (1+1) or (2)
        //If the input is 3, then there will be 3 ways to achieve that. (1+1+1) or (1+2) or (2+1)
        //If the input is 4, then there will be 5 ways to achieve that. (1+1+1+1) or (2+2) or (1+2+1) or (1+1+2) or (2+1+1)
        //If the input is 5, then there will be 8 ways to achieve that. (2+2+1) or (2+1+2) or (1+2+2) or (1+1+1+1+1) and so on.
        //So basically, here if the number of ways to climb stairs is f(n), then f(n) = f(n-1) + f(n-2) which represents a Fibonacci series.
        System.out.println("Number of ways to climb the stairs is: " + numberOfCombinationsToClimbStairs(input));
    }

    static int numberOfCombinationsToClimbStairs(int n) {
        int i = 1, j = 1, temp =0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            for (int k = 0; k <= n-2; k++) {
                temp = i + j;
                i = j;
                j = temp;
            }
        }
        return temp;
    }
}