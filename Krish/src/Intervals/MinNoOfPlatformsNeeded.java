package Krish.src.Intervals;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
//Video reference: https://www.youtube.com/watch?v=dxVcMDI7vyI&ab_channel=takeUforward
//Time Complexity: O(2nlogn) + O(n) //To sort both the arrays it takes O(2nlogn). To traverse both the arrays it takes O(n).
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
            //If next train's arrival time is less than or equal to the previous train's departure time, then we need an extra platform.
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