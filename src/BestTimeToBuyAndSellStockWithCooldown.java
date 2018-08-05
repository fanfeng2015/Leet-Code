// LeetCode #309 (Best Time to Buy and Sell Stock with Cooldown).

// Say you have an array for which the i-th element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as
// you like (i.e., buy one and sell one share of the stock multiple times) with the following 
// restrictions:

// 1. You may not engage in multiple transactions at the same time (i.e., you must sell the 
//    stock before you buy again).
// 2. After you sell your stock, you cannot buy stock on next day (i.e., cooldown 1 day).

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        // sell[0] = 0; 
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
    
    // Time complexity is O(n).
    // Space complexity is O(n), but obviously can be optimized to O(1).
}