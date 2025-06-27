package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
//Video source: https://www.youtube.com/watch?v=Z0hwjftStI4&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=JRAByolWqhw&ab_channel=ApnaCollege
//Time complexity: O(n) + O(n * log(Range)), Range = Sum(arr) - MAX(arr)
//Explanation: O(n) is to calculate the sum.
//Binary search performs between the sum of the array and maximum number of pages in any book, so O(log(Sum(arr) - MAX))
//Every time we check for isPossible function, so O(n * log(Sum(arr) - MAX))
//Space complexity: O(1)

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        int maxPages = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxPages) {
                maxPages = arr[i];
            }
        }

        int low = maxPages, high = sum, ans = -1;
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

    static boolean isPossible(int[] arr, int k, int maxAllowedPages) {
        int countOfStudents = 1, pages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] <= maxAllowedPages) {
                pages += arr[i];
            } else {
                countOfStudents++;
                pages = arr[i];
            }
            if (countOfStudents > k) return false;
        }
        return true;
    }
}