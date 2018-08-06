// LeetCode #518 (Coin Change 2).

// You are given coins of different denominations and a total amount of money. 

// Write a function to compute the number of combinations that make up that amount. 
// You may assume that you have infinite number of each kind of coin.

public class CoinChange2 {

	// M[i]: total number of ways to make up amount i
	public int change(int amount, int[] coins) {
		int[] M = new int[amount + 1];
		M[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				M[i] += M[i - coin];
			}
		}
		return M[amount];
	}

	// Time complexity is O(n*amount).
	// Space complexity is O(amount).

	// Compare LeetCode #518 (Coin Change 2) with LeetCode #377 (Combination Sum
	// IV).
}
