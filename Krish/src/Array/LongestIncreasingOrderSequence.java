package Krish.src.Array;

//Time complexity: O(n)
//Space complexity: O(1)

public class LongestIncreasingOrderSequence {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 2, 4, 6, 7, 0, 1, 2};
        System.out.println(meth1(a));
    }

    static int meth1(int[] a) {
        int count = 1, max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return max;
    }
}