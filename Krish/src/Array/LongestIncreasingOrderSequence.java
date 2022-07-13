package src.Array;

public class LongestIncreasingOrderSequence {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 2, 4, 6, 7, 0, 1, 2};
        System.out.println(meth(a));
    }

    static int meth(int[] a) {
        int i = 0, j = a.length - 1;
        int count = 0, temp = 0, max = 0;
        while (i < j - 1) {
            if (a[i] < a[i + 1]) {
                count++;
                i++;
            } else {
                count++;
                temp = count;
                count = 0;
                i++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}