package Krish.src.DSAlgo.BinarySearch.SuperImportant.BSOnRanges;

//Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//Video source: https://www.youtube.com/watch?v=MG-Ac4TAvTY&ab_channel=takeUforward
//Time complexity: O(n) + O(n * log(Range)), Range = Sum(arr) - MAX(arr)
//Space complexity: O(1)
//Note: Same solution as AllocateMinimumPages

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    static int shipWithinDays(int[] weights, int days) {
        int sumOfWeights = 0;
        for (int weight : weights) {
            sumOfWeights += weight;
        }

        int maxWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
        }

        int low = maxWeight, high = sumOfWeights, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int k, int maxAllowedWeight) {
        int countOfDays = 1, load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] <= maxAllowedWeight) {
                load += arr[i];
            } else {
                countOfDays++;
                load = arr[i];
            }
            if (countOfDays > k) return false;
        }
        return true;
    }
}