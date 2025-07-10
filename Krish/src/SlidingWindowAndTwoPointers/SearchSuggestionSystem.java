package Krish.src.SlidingWindowAndTwoPointers;

//Problem: https://leetcode.com/problems/search-suggestions-system/
//Video source: https://www.youtube.com/watch?v=D4T2N0yAr20&ab_channel=NeetCode
//Time complexity: O(nlogn + n*w + m), n is the length of the products array, w is the length of each word in the product array, m is the length of the searchWord
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "mo", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        int l = 0, r = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char ch = searchWord.charAt(i);
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != ch)) {
                l++;
            }

            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != ch)) {
                r--;
            }

            int remain = r - l + 1;
            List<String> subRes = new ArrayList<>();
            for (int j = 0; j < Math.min(3, remain); j++) {
                subRes.add(products[l + j]);
            }
            result.add(subRes);
        }
        return result;
    }
}