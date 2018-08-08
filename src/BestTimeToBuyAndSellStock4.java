import java.util.Arrays;

// LeetCode #188 (Best Time to Buy and Sell Stock IV).

// Say you have an array for which the i-th element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most k transactions.

public class BestTimeToBuyAndSellStock4 {

	// Generalized solution from LeetCode #123 (Best Time to Buy and Sell Stock
	// III).
	public int maxProfit(int k, int[] prices) {
		k = Math.min(k, prices.length / 2);
		if (k == 0) {
			return 0;
		}
		int[] buy = new int[k], sell = new int[k];
		Arrays.fill(buy, Integer.MIN_VALUE);
		for (int i = 0; i < prices.length; i++) {
			for (int j = 0; j < k; j++) {
				buy[j] = Math.max(buy[j], (j == 0 ? 0 : sell[j - 1]) - prices[i]);
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
			}
		}
		return sell[k - 1];
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k).
}