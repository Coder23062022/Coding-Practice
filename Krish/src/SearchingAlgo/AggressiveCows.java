package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/problems/aggressive-cows/1
//Video source: https://www.youtube.com/watch?v=R_Mfw4ew-Vo&ab_channel=takeUforward
//Time complexity: O(nlogn) + O(n * log(Range)), Range = MAX(arr) - MIN(arr)
//Explanation: nlogn is for sorting.
//Binary search performs between the maximum element in the array and minimum element in the array, so O(log(MAX(arr) - MIN(arr)))
//Every time we check for canWePlace function, so O(n * log(MAX(arr) - MIN(arr)))
//Space complexity: O(1)

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
//        int[] stalls = {1, 2, 4, 8, 9};
        int[] stalls = {0, 3, 4, 7, 9, 10};
        int k = 4;
        System.out.println(aggressiveCows(stalls, k));
    }

    static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length, ans = -1;
        int low = 0, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static boolean canWePlace(int[] stalls, int k, int dist) {
        int countCows = 1, last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                countCows++;
                last = stalls[i];
            }
            if (countCows == k) return true;
        }
        return false;
    }
}