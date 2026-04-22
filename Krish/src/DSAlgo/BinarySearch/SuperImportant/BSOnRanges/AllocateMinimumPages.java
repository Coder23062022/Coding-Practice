package Krish.src.DSAlgo.BinarySearch.SuperImportant.BSOnRanges;

//Problem: https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
//Video source: https://www.youtube.com/watch?v=Z0hwjftStI4&ab_channel=takeUforward
//Video source: https://www.youtube.com/watch?v=JRAByolWqhw&ab_channel=ApnaCollege
//Time complexity: O(n) + O(n * log(Range)), Range = Sum(arr) - MAX(arr)
/*
    TC explanation:
    O(n) is to calculate the sum.
    Binary search performs between the sum of the array and maximum number of pages in any book, so O(log(Sum(arr) - MAX))
    Every time we check for isPossible function, so O(n * log(Sum(arr) - MAX))
*/
//Space complexity: O(1)

public class AllocateMinimumPages {
    public static void main(String[] args) {
//        int[] arr = {12, 34, 67, 90};
        int[] arr = {15, 17, 20};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int sumOfPages = 0;
        for (int pages : arr) {
            sumOfPages += pages;
        }

        int maxPages = 0;
        for (int pages : arr) {
            maxPages = Math.max(maxPages, pages);
        }

        int low = maxPages, high = sumOfPages, ans = -1;
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