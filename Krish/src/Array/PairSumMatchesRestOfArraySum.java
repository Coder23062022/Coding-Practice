package Krish.src.Array;

import java.util.HashSet;
import java.util.Set;

//Time complexity: O(n)
//Space complexity: O(n)

public class PairSumMatchesRestOfArraySum {
    public static void main(String[] args) {
        // Check if there exist two elements in an array whose sum is equal to the sum
        // of rest of the array.
        int[] a = {2, 11, 5, 1, 4, 7};
        if (!checkPair(a)) {
            System.out.println("No pair found");
        }
    }

    //So, we have to find out a and b such that:
    //(a + b) = sum of the whole array - (a + b)
    //=>2 * (a + b) = sum of the whole array
    //=>(a + b) = sum of the whole array / 2

    private static boolean checkPair(int[] arr) {
        int sum = 0;
        //Find sum of the whole array.
        for (int j : arr) {
            sum += j;
        }

        // If sum of array is not even then we can not divide it into two parts.
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        //Note: Now it becomes two sum problem where we have to find two elements which matches the above sum.

        // For each element arr[i], see if there is another element with value sum - arr[i].
        Set<Integer> hs = new HashSet<>();
        for (int j : arr) {
            int diff = sum - j;
            if (hs.contains(diff) && diff == (int) hs.toArray()[hs.size() - 1]) {
                System.out.println("Pair is: " + j + ',' + diff);
                return true;
            }
            hs.add(j);
        }
        return false;
    }
}