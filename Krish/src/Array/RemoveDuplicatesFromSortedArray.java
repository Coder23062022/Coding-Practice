package src.Array;

//Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//Video source: https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
//Time complexity: O(n)

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // int a[] = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4 };
        int[] a = {1, 1, 1, 2};
        System.out.println("Length is: " + findLengthWithoutDuplicates(a));
    }

    // In this algorithm, we focused on the length of the array which should come when no duplicates are present.
    static int findLengthWithoutDuplicates(int[] a) {
        if (a.length == 0)
            return 0;

        int i = 1, j = 1;
        while (j < a.length) {
            if (a[j] != a[j - 1]) {
                a[i] = a[j];
                i++;
            }
            j++;
        }
        return i;
    }
}