package src.Intervals;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
//Video reference: https://www.youtube.com/watch?v=dxVcMDI7vyI&ab_channel=takeUforward
//Time Complexity: O(N * log N), One traversal O(n) of both the array is needed after sorting.
//Space complexity: O(1)

public class MinNoOfPlatformsNeeded {
    static int findPlatform(int[] arr, int[] dep, int n) {
        //Sort arrival and departure arrays.
        Arrays.sort(arr);
        Arrays.sort(dep);

        //plat_needed indicates number of platforms needed at a time.
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            //If next event in sorted order is arrival, increment count of platforms needed, else decrement count of
            //platforms needed.
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--; //This means vacating an existing platform.
                j++;
            }
            // Update result if needed
            result = Math.max(result, plat_needed);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
    }
}