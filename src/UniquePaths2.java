// LeetCode #63 (Unique Paths II).

// You are given an m x n integer array grid. There is a robot initially located at the top-left corner
// (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
// The robot can only move either down or right at any point in time.

// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot 
// include any square that is an obstacle.

// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

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

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[] prev = new int[n], next = new int[n];
		for (int j = 0; j < n; j++) {
			int left = (j == 0) ? 1 - obstacleGrid[0][0] : prev[j - 1];
			prev[j] = (obstacleGrid[0][j] == 1) ? 0 : left;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int left = (j == 0) ? 0 : next[j - 1];
				next[j] = (obstacleGrid[i][j] == 1) ? 0 : prev[j] + left;
			}
			prev = next;
			next = new int[n];
		}
		return prev[n - 1];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(n).
	
	// Technically, unless the previously allocated array is deallocated, the space
	// isn't actually saved.
}
