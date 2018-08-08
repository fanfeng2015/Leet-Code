// LeetCode #123 (Best Time to Buy and Sell Stock III).

// Say you have an array for which the i-th element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the
// stock before you buy again).

public class BestTimeToBuyAndSellStock3 {

	public int maxProfit(int[] prices) {
		int buyOne = Integer.MIN_VALUE, buyTwo = Integer.MIN_VALUE;
		int sellOne = 0, sellTwo = 0;
		for (int i = 0; i < prices.length; i++) {
			// If this is the first stock I buy, and if I buy on day i, do I save money than
			// if I buy on any previous day?
			// If yes, then I buy on day i. Otherwise, I buy on some previous day, whichever
			// is the cheapest.
			buyOne = Math.max(buyOne, -prices[i]);
			// If this is the first stock I sell, and if I sell on day i, do I make more
			// money than if I sell on any previous day?
			// If yes, then I sell on day i. Otherwise, I sell on some previous day,
			// whichever gives me the most profit.
			sellOne = Math.max(sellOne, buyOne + prices[i]);
			// Now that I have bought and sold the first stock, I have sellOne money at
			// hand, instead of 0.
			buyTwo = Math.max(buyTwo, sellOne - prices[i]);
			sellTwo = Math.max(sellTwo, buyTwo + prices[i]);
		}
		return sellTwo;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}