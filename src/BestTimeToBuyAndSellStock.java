// LeetCode #121 (Best Time to Buy and Sell Stock).

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to 
// sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int minPrice = prices[0], maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int maxProfit2(int[] prices) {
		int max = 0, maxCur = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
			max = Math.max(max, maxCur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int maxProfit3(int[] prices) {
		int buy = Integer.MIN_VALUE, sell = 0;
		for (int i = 0; i < prices.length; i++) {
			buy = Math.max(buy, -prices[i]);
			sell = Math.max(sell, prices[i] + buy);
		}
		return sell;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
