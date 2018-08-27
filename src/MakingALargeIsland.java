import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LeetCode #827 (Making A Large Island).

// In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

// After, what is the size of the largest island? (An island is a 4-directionally connected 
// group of 1s).

public class MakingALargeIsland {

	Map<Integer, Integer> countMap = new HashMap<>();

	public int largestIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int max = 0;
		paint(grid);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cur = (grid[i][j] == 0) ? 1 + connect(grid, i, j) : countMap.get(grid[i][j]);
				max = Math.max(max, cur);
			}
		}
		return max;
	}

	private void paint(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int color = 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					countMap.put(color, paint(grid, i, j, color));
					color++;
				}
			}
		}
	}

	// Paint all connected 1s to (row, col) with color, and return the total count.
	private int paint(int[][] grid, int row, int col, int color) {
		int m = grid.length, n = grid[0].length;
		if (indexOutOfBound(m, n, row, col) || grid[row][col] != 1) {
			return 0;
		}
		grid[row][col] = color;
		return 1 + paint(grid, row - 1, col, color) + paint(grid, row, col + 1, color)
				+ paint(grid, row + 1, col, color) + paint(grid, row, col - 1, color);
	}

	private int connect(int[][] grid, int row, int col) {
		int m = grid.length, n = grid[0].length;
		int cur = 0;
		Set<Integer> surround = new HashSet<>(Arrays.asList(0)); // colors
		cur += (!indexOutOfBound(m, n, row - 1, col) && surround.add(grid[row - 1][col]))
				? countMap.get(grid[row - 1][col])
				: 0;
		cur += (!indexOutOfBound(m, n, row, col + 1) && surround.add(grid[row][col + 1]))
				? countMap.get(grid[row][col + 1])
				: 0;
		cur += (!indexOutOfBound(m, n, row + 1, col) && surround.add(grid[row + 1][col]))
				? countMap.get(grid[row + 1][col])
				: 0;
		cur += (!indexOutOfBound(m, n, row, col - 1) && surround.add(grid[row][col - 1]))
				? countMap.get(grid[row][col - 1])
				: 0;
		return cur;
	}

	private boolean indexOutOfBound(int m, int n, int row, int col) {
		return row < 0 || row >= m || col < 0 || col >= n;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
