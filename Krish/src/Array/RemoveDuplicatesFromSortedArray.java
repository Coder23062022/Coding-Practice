package src.Array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // int a[] = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4 };
        int[] a = {1, 1, 1, 2};
        System.out.println("Length is: " + findLengthWithoutDuplicates(a));
    }

    // In this algorithm, we focused on the length of the array which should come
    // when no duplicates are present.
    static int findLengthWithoutDuplicates(int[] a) {
        if (a.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[j] != a[i]) {
                i++;
                a[i] = a[j];
            }
        }
        // In the below commented code if you will print the array, you can see
        // duplicate values are present in the output array, but as our main target is
        // to find the length of the duplicate free array, we can ignore the final array
        // which is getting formed.
        /*
         * for (int k = 0; k < a.length; k++) { System.out.println(a[k]); }
         */
        return i + 1;
    }
}