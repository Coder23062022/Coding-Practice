package Krish.src.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//Problem: https://leetcode.com/problems/combination-sum-iii/
//Video source: https://www.youtube.com/watch?v=z2Zk04UDYnY&ab_channel=AlgorithmHQ
//Time Complexity: O(2^n * k)
//Space Complexity: O(k * x), k is the average length of combination and x is the no. of combinations

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), res);
        return res;
    }

    //Here we are using the index only to calculate the target
    static void solve(int index, int k, int n, List<Integer> ds, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        if (index > 9) return;
        if (k < 0 || n < 0) return;

        ds.add(index);
        solve(index + 1, k - 1, n - index, ds, res);
        ds.remove(ds.size() - 1);
        solve(index + 1, k, n, ds, res);
    }
}