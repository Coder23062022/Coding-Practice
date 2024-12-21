package Krish.src.Array;

import java.util.HashSet;

//Problem: https://leetcode.com/problems/contains-duplicate/
//Time complexity: O(n)
//Space complexity: O(n)

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 7, 9, 5, 2, 7};
        HashSet<Integer> hs = new HashSet<>();
        System.out.println("Duplicate numbers are:");
        for (int j : a) {
            if (hs.contains(j)) {
                System.out.println(j);
            } else {
                hs.add(j);
            }
        }
    }
}