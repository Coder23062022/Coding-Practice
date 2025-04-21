package Krish.src.SearchingAlgo;

//Problem: https://leetcode.com/problems/koko-eating-bananas/description/
//Video source: https://www.youtube.com/watch?v=qyfekrNni90&ab_channel=takeUforward
//Time complexity: O(nlogm)), m is the maximum element in the piles array
//Space complexity: O(1)

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
//        int[] piles = {312884470};
//        int h = 968709470;
        System.out.println(minEatingSpeed(piles, h));
    }

    static int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = maxElement(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHours = validateMid(piles, mid);

            if (totalHours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int validateMid(int[] piles, int mid) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / (double) mid);
        }
//        for (int pile : piles) {
//            totalHours += Math.ceil(1.0 * pile / mid);
//        }
        return totalHours;

    }

    static int maxElement(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}