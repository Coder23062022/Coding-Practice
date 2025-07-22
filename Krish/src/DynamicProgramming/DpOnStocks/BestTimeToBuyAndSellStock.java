package Krish.src.DynamicProgramming.DpOnStocks;

//Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//Video source: https://www.youtube.com/watch?v=excAOvwF_Wk&ab_channel=takeUforward
//Time complexity: O(n)
//Space complexity: O(1)

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is: " + maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int profit, max_profit = 0, min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - min_price;
            max_profit = Math.max(max_profit, profit);
            min_price = Math.min(min_price, prices[i]);
        }
        return max_profit;
    }
}