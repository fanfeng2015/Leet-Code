// LeetCode #63 (Unique Paths II).

// Now consider if some obstacles are added to the grids. How many unique paths could there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] M = new int[m][n];
		M[m - 1][n - 1] = obstacleGrid[m - 1][n - 1] == 1 ? 0 : 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if ((i != m - 1 || j != n - 1) && obstacleGrid[i][j] != 1) {
					M[i][j] = ((i < m - 1) ? M[i + 1][j] : 0) + ((j < n - 1) ? M[i][j + 1] : 0);
				}
			}
		}
		return M[0][0];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(n).
}
