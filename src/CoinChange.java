import java.util.Arrays;

// LeetCode #322 (Coin Change).

// You are given coins of different denominations and a total amount of money amount. 

// Write a function to compute the fewest number of coins that you need to make up that amount. 
// If that amount of money cannot be made up by any combination of the coins, return -1.

public class CoinChange {

	// M[i]: fewest number of coins that are needed to make up amount i
	public int coinChange(int[] coins, int amount) {
		int[] M = new int[amount + 1];
		Arrays.fill(M, amount + 1);
		M[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					M[i] = Math.min(M[i], M[i - coins[j]] + 1);
				}
			}
		}
		return M[amount] == amount + 1 ? -1 : M[amount];
	}

	// Time complexity is O(n*amount).
	// Space complexity is O(amount).
}
