package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/permutation-sequence/
//Video source: https://www.youtube.com/watch?v=wT7gcXLYoao&ab_channel=takeUforward
//Time Complexity: O(n)
//Space Complexity: O(n)

public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        System.out.println(getPermutation(n, k));

    }

    static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        String ans = "";
        k = k - 1;

        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);

            if (numbers.size() == 0) break;

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}