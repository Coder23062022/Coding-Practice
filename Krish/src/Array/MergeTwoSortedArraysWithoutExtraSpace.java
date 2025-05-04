package Krish.src.Array;

import java.util.Arrays;

//Problem: https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
//Video source: https://www.youtube.com/watch?v=n7uwj04E0I4&t=1052s&ab_channel=takeUforward
//Time complexity: O(min(n, m)) + O(nlogn) + O(mlogm)
//Space complexity: O(1)

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20}, b = {2, 3, 8, 13};
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    static void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int l = n - 1;
        int r = 0;

        //Merge in reverser order.
        while (l >= 0 && r < m) {
            if (a[l] > b[r]) {
                int temp = a[l];
                a[l] = b[r];
                b[r] = temp;
                l--;
                r++;
            } else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}