// LeetCode #714 (Best Time to Buy and Sell Stock with Transaction Fee).

// Your are given an array of integers prices, for which the i-th element is the price
// of a given stock on day i; and a non-negative integer fee representing a transaction 
// fee.

// You may complete as many transactions as you like, but you need to pay the transaction
// fee for each transaction. You may not buy more than 1 share of a stock at a time (i.e.,
// you must sell the stock share before you buy again.)

// Return the maximum profit you can make.

public class BestTimeToBuyAndSellStockWithTransactionFee {

	public int maxProfit(int[] prices, int fee) {
		int prevBuy = 0, buy = -prices[0], sell = 0;
		for (int i = 1; i < prices.length; i++) {
			prevBuy = buy;
			buy = Math.max(buy, sell - prices[i]);
			sell = Math.max(sell, prevBuy + prices[i] - fee);
		}
		return sell;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
