import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LeetCode #827 (Making A Large Island).

// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

// Return the size of the largest island in grid after applying this operation.

// An island is a 4-directionally connected group of 1s.

public class MakingALargeIsland {

	// --------------------------------------------------
	// 2023
	// --------------------------------------------------
	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int largestIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length, group = 2, result = 0;
		Map<Integer, Integer> groupToArea = new HashMap<>(); // { group: area }
		groupToArea.put(0, 0);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					groupToArea.put(group, DFS(grid, i, j, group));
					result = Math.max(result, groupToArea.get(group++)); // increment group number
				}
			}
		}
		// up to this point, each island is marked as the group that it belongs to
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// can change grid[i][j] to 1, then add up neighbor's area (neighbors in the
				// same group should be added only once)
				if (grid[i][j] == 0) {
					int cur = 1;
					Set<Integer> addedGroups = new HashSet<>();
					for (int[] dir : DIRECTIONS) {
						int row = i + dir[0], col = j + dir[1];
						if (row >= 0 && row < m && col >= 0 && col < n && addedGroups.add(grid[row][col])) {
							cur += groupToArea.get(grid[row][col]);
						}
					}
					result = Math.max(result, cur);
				}
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	private int DFS(int[][] grid, int row, int col, int group) {
		int m = grid.length, n = grid[0].length;
		if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
			return 0;
		}
		grid[row][col] = group;
		return 1 + DFS(grid, row - 1, col, group) + DFS(grid, row, col + 1, group) + DFS(grid, row + 1, col, group)
				+ DFS(grid, row, col - 1, group);
	}

	// --------------------------------------------------
	// 2018
	// --------------------------------------------------
	Map<Integer, Integer> countMap = new HashMap<>();

	public int largestIsland2(int[][] grid) {
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
