import java.util.Arrays;

// LeetCode #322 (Coin Change).

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total 
// amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination
// of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

public class CoinChange {

	// dp[i]: fewest number of coins that are needed to make up amount i
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] == (amount + 1) ? -1 : dp[amount];
	}

	// Time complexity is O(amount * n), where n is the number of coins.
	// Space complexity is O(amount).
}
