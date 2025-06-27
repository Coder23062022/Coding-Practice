package Krish.src.SearchingAlgo;

import java.util.Arrays;

//Problem: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
//Video source: https://www.youtube.com/watch?v=TXAuxeYBTdg&ab_channel=takeUforward
//Time complexity: O(n * log(Range)), Range = MAX(arr) - MIN(arr) + 1
//Explanation: Binary search performs between the max value of the array and min value of the array, so O(log(MAX(arr) - MIN(arr) + 1))
//Every time we check for isPossible function, so O( n * log(MAX(arr) - MIN(arr) + 1))
//Space complexity: O(1)

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDay, k, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int k, int m, int maxAllowedDays) {
        int countOfBloomedFlowers = 0, noOfBouquets = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= maxAllowedDays) {
                countOfBloomedFlowers++;
            } else {
                noOfBouquets += countOfBloomedFlowers / k;
                countOfBloomedFlowers = 0;
            }
        }
        noOfBouquets += countOfBloomedFlowers / k;
        return noOfBouquets >= m;
    }
}