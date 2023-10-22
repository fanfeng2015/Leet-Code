// LeetCode #695 (Max Area of Island).

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal
// or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length, max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, DFS(grid, i, j));
				}
			}
		}
		return max;
	}

	private int DFS(int[][] grid, int row, int col) {
		int m = grid.length, n = grid[0].length;
		if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
			return 0;
		}
		grid[row][col] = 0;
		return 1 + DFS(grid, row - 1, col) + DFS(grid, row, col + 1) + DFS(grid, row + 1, col)
				+ DFS(grid, row, col - 1);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	// Follow up (Google): You are allowed to change one 0 to 1.
	// Answer: { index: island # }, { island #: area }.
}
