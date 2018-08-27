// LeetCode #695 (Max Area of Island).

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
// (representing land) connected 4-directionally (horizontal or vertical.) You 
// may assume all four edges of the grid are surrounded by water.

// Find the maximum area of an island in the given 2D array. (If there is no island, 
// the maximum area is 0.)

public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, maxAreaOfIsland(grid, i, j));
				}
			}
		}
		return max;
	}

	private int maxAreaOfIsland(int[][] grid, int row, int col) {
		int m = grid.length, n = grid[0].length;
		if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
			grid[row][col] = 0;
			return 1 + maxAreaOfIsland(grid, row - 1, col) + maxAreaOfIsland(grid, row, col + 1)
					+ maxAreaOfIsland(grid, row + 1, col) + maxAreaOfIsland(grid, row, col - 1);
		}
		return 0;
	}
	
	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
