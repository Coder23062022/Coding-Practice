package Krish.src.DSAlgo.Array;

//Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Video source: https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
//Reference: https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
//Time complexity: O(n)
//Space complexity: O(1)

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4};
//        int[] a = {1, 1, 1, 2};
        int n = a.length;
        n = removingDuplicates(a, n);
        System.out.println("New array length is: " + n);
        System.out.print("New Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int removingDuplicates(int[] a, int n) {
        if (n == 0 || n == 1)
            return n;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (a[j] != a[i]) {
                a[i + 1] = a[j];
                i++;
            }
        }
        return i + 1;
    }
}