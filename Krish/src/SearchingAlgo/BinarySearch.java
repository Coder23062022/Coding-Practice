package SearchingAlgo;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {5, 9, 15, 20, 23, 29, 65};
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the item you want to search:");
        int data = sc.nextInt();
        int result = binarySearch(a, data);
        System.out.println(result == -1 ? "Element is not present" : "Element is found at index:" + result);
    }

    static int binarySearch(int[] a, int data) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (data == a[mid]) {
                return mid;
            } else if (data < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // if we reach here, then element was not present
        return -1;
    }
}