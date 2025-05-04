package Krish.src.Array;

//Problem: https://leetcode.com/problems/find-missing-and-repeated-values/
//Similar problem: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
//Video source: https://www.youtube.com/watch?v=2D0D8HE6uak&ab_channel=takeUforward
//Time complexity: O(n ^ 2)
//Space complexity: O(1)

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {2, 2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }

    static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;

        long expectedSum = (long) nSquared * (nSquared + 1) / 2;
        long expectedSumSquares = (long) nSquared * (nSquared + 1) * (2 * nSquared + 1) / 6;

        long actualSum = 0, actualSumSquares = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                actualSum += grid[i][j];
                actualSumSquares += (long) grid[i][j] * grid[i][j];
            }
        }

        // a - b
        long diffSum = actualSum - expectedSum;

        // a² - b²
        long diffSumSquares = actualSumSquares - expectedSumSquares;

        // a + b = (a² - b²) / (a - b)
        long sumAB = diffSumSquares / diffSum;

        // Now we can find a and b
        int a = (int) ((sumAB + diffSum) / 2);
        int b = (int) ((sumAB - diffSum) / 2);

        return new int[]{a, b};
    }
}