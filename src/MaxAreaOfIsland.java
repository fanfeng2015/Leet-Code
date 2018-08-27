// LeetCode #695 (Max Area of Island).

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
// (representing land) connected 4-directionally (horizontal or vertical.) You 
// may assume all four edges of the grid are surrounded by water.

// Find the maximum area of an island in the given 2D array. (If there is no island, 
// the maximum area is 0.)

public class MaxAreaOfIsland {

	private int cur;

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					cur = 0;
					DFS(grid, i, j);
					max = Math.max(max, cur);
				}
			}
		}
		return max;
	}

	private void DFS(int[][] grid, int row, int col) {
		int m = grid.length, n = grid[0].length;
		if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
			return;
		}
		cur++;
		grid[row][col] = 0;
		DFS(grid, row - 1, col);
		DFS(grid, row, col + 1);
		DFS(grid, row + 1, col);
		DFS(grid, row, col - 1);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
