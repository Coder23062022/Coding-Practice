package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
//Video source: https://www.youtube.com/watch?v=thUd_WJn6wk&ab_channel=takeUforward
//Time complexity: O(n) + O(n * log(Range)), Range = Sum(arr) - MAX(arr)
//Space complexity: O(1)
//Note: Same solution as AllocateMinimumPages

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;
        System.out.println(minTime(arr, k));
    }

    static int minTime(int[] arr, int k) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        int maxBoard = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxBoard) {
                maxBoard = arr[i];
            }
        }

        int low = maxBoard, high = sum, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int k, int maxTime) {
        int countOfPainters = 1, currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum + arr[i] <= maxTime) {
                currSum += arr[i];
            } else {
                countOfPainters++;
                currSum = arr[i];
            }
            if (countOfPainters > k) return false;
        }
        return true;
    }
}