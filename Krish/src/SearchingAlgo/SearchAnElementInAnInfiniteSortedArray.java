package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
//Video source: https://www.youtube.com/watch?v=awMDD7sGWVU&ab_channel=AnujKumarSharma
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class SearchAnElementInAnInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        int ans = findPos(arr, target);
        System.out.println(ans);
    }

    static int findPos(int[] arr, int target) {
        int low = 0, high = 1;
        while (target > arr[high]) {
            low = high;
            high = 2 * high;
        }
        return binarySearch(arr, target, low, high);
    }

    static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}