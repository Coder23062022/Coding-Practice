package src.SlidingWindow;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        if (a == null || a.length == 0)
            return;

        //Idea is to take two pointers - left and right. Right pointer will just move to the right if the element is 0.
        //If the element is non-zero, then right pointer value and left pointer value will be swapped and both will be incremented by 1.

        int left = 0, right = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
            }
            right++;
        }
        System.out.println("After moving all the zeros at the end, the array is: " + Arrays.toString(a));
    }
}