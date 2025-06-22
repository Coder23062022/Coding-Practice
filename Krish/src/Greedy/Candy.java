package Krish.src.Greedy;

//Problem: https://leetcode.com/problems/candy/
//Video source: https://www.youtube.com/watch?v=IIqVFvKE6RY&ab_channel=takeUforward
//Time complexity: O(n)

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    //Space complexity: O(n)
    static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int curr = 1, right = 1, sum = Math.max(1, left[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr = right + 1;
            } else {
                curr = 1;
            }
            right = curr;
            sum += Math.max(left[i], curr);
        }
        return sum;
    }

    //Space complexity: O(1)
    static int candyWithSlopePattern(int[] ratings) {
        int n = ratings.length;
        int i = 1, sum = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) { //Increasing slope
                peak++;
                sum += peak;
                i++;
            }

            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) { //Decreasing slope
                sum += down;
                down++;
                i++;
            }

            if (down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }
}