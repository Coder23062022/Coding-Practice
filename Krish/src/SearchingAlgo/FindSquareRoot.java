package SearchingAlgo;

import java.util.Scanner;

public class FindSquareRoot {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give an input:");
        int input = sc.nextInt();
        System.out.println("Square root of " + input + " is: " + findSquareRoot(input));
    }

    // using Binary Search
    static int findSquareRoot(int data) {
        int low = 0;
        int high = data;

        if (data < 2) {
            return data;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == data) {
                return mid;
            } else if (mid * mid < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //The flow will come here only when the input is not a perfect square. In that case return the last 'high' value.
        return high;
    }
}