package src.Recursion;

//Problem: https://leetcode.com/problems/powx-n/

public class PowImplementation {
    public static void main(String[] args) {
        System.out.println(pow1(2, 5));
        System.out.println(pow2(5, 3));
        System.out.println(pow2(2, -2));
    }

    /*
     * This algorithm will give you O(n) time complexity.
     * n^p = 1, when p = 0
     *     = n *n^(p-1), when p>0
     */

    static int pow1(int n, int p) {
        if (p == 0) {
            return 1;
        } else {
            return n * pow1(n, p - 1);
        }
    }


    /*
     * This algorithm will give you O(logn) time complexity.
     * n^p = 1, when p = 0
     * 	   = n^(p/2) * n^(p/2), when p is even
     *     = n *n^(p-1), when p is odd
     */

    static int pow2(int n, int p) {
        if (p < 0) return 1 / n * pow2(1 / n, -(p + 1));
        if (p == 0) {
            return 1;
        } else if (p == 2) {
            return n * n;
        } else if (p % 2 == 0) {
            int y = pow2(n, p / 2);
            return y * y;
        } else {
            return n * pow2(n, p - 1);
        }
    }
}