package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/problems/implement-upper-bound/1
//Video source: https://www.youtube.com/watch?v=6zhGS79oQ4k&ab_channel=takeUforward
//Time Complexity: O(logn)
//Space Complexity: O(1)

public class ImplementLowerAndUpperBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 8, 8, 11, 11, 11, 12};
        int target = 6;
        System.out.println("Lower bound is: " + lowerBound(arr, target));
        System.out.println("Upper bound is: " + upperBound(arr, target));
    }

    static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, index = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, index = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}