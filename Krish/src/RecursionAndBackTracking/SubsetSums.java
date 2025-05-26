package Krish.src.RecursionAndBackTracking;

//Problem: https://www.geeksforgeeks.org/problems/subset-sums2234/1
//Video source: https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12&ab_channel=takeUforward
//Time Complexity: O(2^n + 2^nlog(2^n))
//Space Complexity: O(2^n + 2^nlog(2^n))

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(subsetSums(arr));
    }

    static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        func(0, 0, arr, res);
        Collections.sort(res);
        return res;
    }

    static void func(int index, int sum, int[] arr, ArrayList<Integer> res) {
        if (index == arr.length) {
            res.add(sum);
            return;
        }
        func(index + 1, sum + arr[index], arr, res); //pick
        func(index + 1, sum, arr, res); //not pick
    }
}