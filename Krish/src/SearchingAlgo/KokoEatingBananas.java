package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/koko-eating-bananas
//Video source: https://www.youtube.com/watch?v=qyfekrNni90&ab_channel=takeUforward
//Time complexity: O(nlogm)), m is the maximum element in the piles array
//Space complexity: O(1)

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
//        int[] piles = {312884470};
//        int h = 968709470;
        System.out.println(minEatingSpeed(piles, h));
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = Arrays.stream(piles).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean isPossible(int[] piles, int h, int bananasPerHour) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / (double) bananasPerHour);
        }
        return totalHours <= h;
    }
}