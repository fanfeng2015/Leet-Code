// LeetCode #121 (Best Time to Buy and Sell Stock).

// Say you have an array for which the i-th element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (i.e., buy one and sell
// one share of the stock), design an algorithm to find the maximum profit.

// Note that you cannot sell a stock before you buy one.

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int max = 0, maxCur = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
			max = Math.max(max, maxCur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int maxProfit2(int[] prices) {
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
