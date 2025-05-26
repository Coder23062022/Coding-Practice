package Krish.src.StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Problem: https://leetcode.com/problems/online-stock-span/
//Video source: https://www.youtube.com/watch?v=eay-zoSRkVc&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=15&ab_channel=takeUforward
//Time complexity: O(2n)
//Space complexity: O(n)

public class OnlineStockSpan {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        StockSpanner stockSpanner = new StockSpanner();
        result.add(stockSpanner.next(100));
        result.add(stockSpanner.next(80));
        result.add(stockSpanner.next(60));
        result.add(stockSpanner.next(70));
        result.add(stockSpanner.next(60));
        result.add(stockSpanner.next(75));
        result.add(stockSpanner.next(85));
        System.out.println(result);
    }

    static class StockSpanner {
        Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && price >= stack.peek()[0]) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }
}