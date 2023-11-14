// LeetCode #64 (Minimum Path Sum).

// Given a m x n grid filled with non-negative numbers, find a path from top left 
// to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

public class MinimumPathSum {

	// ------------------------------ 2018 ------------------------------
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] M = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int down = i < m - 1 ? M[i + 1][j] : Integer.MAX_VALUE;
				int right = j < n - 1 ? M[i][j + 1] : Integer.MAX_VALUE;
				M[i][j] = grid[i][j] + ((i == m - 1 && j == n - 1) ? 0 : Math.min(down, right));
			}
		}
		return M[0][0];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(n).

	// Follow up (Google): Reconstruct the path?
	// 1. DP: While computing value in each cell, also record a direction.
	// 2. DFS.

	// ------------------------------ 2023 ------------------------------
	public int minPathSum2(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int up = (i == 0) ? Integer.MAX_VALUE : dp[i - 1][j];
				int left = (j == 0) ? Integer.MAX_VALUE : dp[i][j - 1];
				dp[i][j] = grid[i][j] + ((i == 0 && j == 0) ? 0 : Math.min(up, left));
			}
		}
		return dp[m - 1][n - 1];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(n).
}
