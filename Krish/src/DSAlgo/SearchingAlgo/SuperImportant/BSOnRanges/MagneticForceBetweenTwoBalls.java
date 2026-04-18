package Krish.src.DSAlgo.SearchingAlgo.SuperImportant.BSOnRanges;

//Problem: https://leetcode.com/problems/magnetic-force-between-two-balls/
//Time complexity: O(nlogn) + O(n * log(Range)), Range = MAX(arr) - MIN(arr)
//Space complexity: O(1)
//Note: Same solution as AggressiveCows

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
//        int[] position = {5,4,3,2,1,1000000000}; int m = 2;
        System.out.println(maxDistance(position, m));
    }

    static int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 0, high = position[n - 1] - position[0], ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(position, m, mid)) {
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