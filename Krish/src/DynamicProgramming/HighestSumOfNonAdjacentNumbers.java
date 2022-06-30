package src.DynamicProgramming;

public class HighestSumOfNonAdjacentNumbers {
    public static void main(String[] args) {
        int[] a = {2, 7, 9, 5, 6, 6};
        System.out.println(highestSumOfNonAdjacentNos(a));
    }

    static int highestSumOfNonAdjacentNos(int[] a) {
        int prev = 0, curr = 0;
        for (int x : a) {
            int temp = curr;
            curr = Math.max(x + prev, curr);
            prev = temp;
        }
        return curr;
    }
}
