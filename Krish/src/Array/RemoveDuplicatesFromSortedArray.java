package Krish.src.Array;

//Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Video source: https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
//Reference: https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
//Time complexity: O(n)
//Space complexity: O(1)

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
         int a[] = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4 };
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
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j] = a[i];
                j++;
            }
        }
        a[j++] = a[n - 1];
        return j;
    }
}