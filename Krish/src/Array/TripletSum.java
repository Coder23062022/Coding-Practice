package src.Array;

import java.util.HashSet;
import java.util.Set;

public class TripletSum {
    public static void main(String[] args) {
        int[] A = {1, 4, 45, 6, 10, 8};
        int sum = 22;
        int arr_size = A.length;

        System.out.println(find3Numbers(A, arr_size, sum));
    }

    // returns true if there is triplet with sum equal to 'sum' present in A[].
    // Also, prints the triplet.
    static boolean find3Numbers(int[] A, int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in sub-array A[i+1..n-1] with sum equal to sum - A[i]
            Set<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}