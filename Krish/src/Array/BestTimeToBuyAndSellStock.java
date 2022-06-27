package src.Array;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit is: " + maxProfit(prices));
    }

    static int maxProfit(int[] prices) {
        int profit = 0, max_profit = 0, min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - min_price;
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, profit);
        }
        return max_profit;
    }
}
