package src.SlidingWindow;

public class SegregatePositiveNegativeNumbersNotMaintainingOrder {
    public static void main(String[] args) {
        int[] a = {7, -1, -5, -2, 3, 2, -4, 1, 0};
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            if (a[left] < 0) {
                left++;
            } else {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                right--;
            }
        }

        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
