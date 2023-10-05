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

// [1, 2, 3], target = 4

// #518: each coin is grouped together, won't see cases like [1, 2, 1]
// [1, 1, 1, 1, 1] -> (/), (1), (1, 1), (1, 1, 1), (1, 1, 1, 1)
// [1, 1, 2, 2, 3] -> (/), (1), +(2),   +(1, 2),   +(1, 1, 2) or (2, 2)  
// [1, 1, 2, 3, 4] ->                   +(3),      +(1, 3)


// #377: 
// [1, 1, 0, 0, 0] -> (1)
// [1, 1, 2, 0, 0] -> (2) / (1, 1)
// [1, 1, 2, 4, 0] -> (3) or (1, 2) or (2, 1) / (1, 1, 1)
// [1, 1, 2, 4, 7]

// If order doesn't matter, loop coins first.
// If order does matter, loop target first.
