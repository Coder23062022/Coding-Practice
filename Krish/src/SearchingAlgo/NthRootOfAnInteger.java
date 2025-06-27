package Krish.src.SearchingAlgo;

//Problem: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
//Video reference: https://www.youtube.com/watch?v=rjEJeYCasHs&t=6s&ab_channel=takeUforward
//Time complexity: O(nlogm)
//Space complexity: O(1)

public class NthRootOfAnInteger {
    public static void main(String[] args) {
        int n = 1, m = 14;
        int result = nthRoot(n, m);
        System.out.println(result);
    }

    static int nthRoot(int n, int m) {
        if (n == 1) return m;

        long low = 0, high = m, ans = -1;
        while (low <= high) {
            long mid = (low + high) / 2;
            long x = mid;
            for (int i = 1; i < n; i++) {
                x *= mid;
                if (x > m) break;
            }
            if (x == m) {
                ans = mid;
                break;
            } else if (x > m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (int) ans;
    }
}