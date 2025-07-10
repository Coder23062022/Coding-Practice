package Krish.src.SlidingWindowAndTwoPointers;

//Time complexity: O(n*window)
//Space complexity: O(1)

public class SegregatingPositiveNegativeNumbersMaintainingOrder {
    static void method1(int[] arr, int n) {
        // Count negative numbers
        int count_negative = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] < 0)
                count_negative++;

        // Run a loop until all negative numbers are moved to the beginning
        int i = 0, j = 1;
        while (i != count_negative) {

            // If number is negative, update position of next positive number.
            if (arr[i] < 0) {
                i++;
                j = i + 1; //To start checking again from next element after arr[i].
            }

            // If number is positive, swap arr[i] and arr[j] and increment j.
            else if (arr[i] > 0 && j < n) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
        }
    }

    public static void method2(int[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                for (int k = j; k > i; k--) {
                    int temp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = temp;
                }
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
//        int n = arr.length;
//        segregate(arr, n);
        int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        method2(arr);
        for (int j : arr) System.out.print(j + " ");
    }
}