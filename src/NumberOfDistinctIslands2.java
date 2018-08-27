import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #711 (Number of Distinct Islands II).

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid 
// are surrounded by water.

// Count the number of distinct islands. An island is considered to be the same as another if they
// have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or 
// reflection (left/right direction or up/down direction).

public class NumberOfDistinctIslands2 {

	private int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numDistinctIslands(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int count = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					List<Integer> coordinates = new ArrayList<>();
					DFS(grid, i, j, coordinates);
					if (set.add(canonical(coordinates, m, n))) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private void DFS(int[][] grid, int row, int col, List<Integer> coordinates) {
		int m = grid.length, n = grid[0].length;
		if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
			grid[row][col] = 0;
			coordinates.add(row * n + col);
			for (int[] direction : directions) {
				DFS(grid, row + direction[0], col + direction[1], coordinates);
			}
		}
	}

	private String canonical(List<Integer> coordinates, int m, int n) {
		String result = "";
		int factor = m + n;
		int[] xs = new int[coordinates.size()];
		int[] ys = new int[coordinates.size()];
		int[] output = new int[coordinates.size()];
		for (int c = 0; c < 8; ++c) {
			int index = 0;
			for (Integer coordinate : coordinates) {
				int x = coordinate / n;
				int y = coordinate % n;
				// (x, y), (x, -y), (-x, y), (-x, -y), (y, x), (y, -x), (-y, x), (-y, -x)
				xs[index] = c <= 1 ? x : c <= 3 ? -x : c <= 5 ? y : -y;
				ys[index] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
				index++;
			}
			int minX = min(xs);
			int minY = min(ys);
			for (int i = 0; i < coordinates.size(); i++) {
				output[i] = (xs[i] - minX) * factor + (ys[i] - minY);
			}
			Arrays.sort(output);
			String candidate = Arrays.toString(output);
			if (result.compareTo(candidate) < 0) {
				result = candidate;
			}
		}
		return result;
	}

	private int min(int[] array) {
		int min = array[0];
		for (int i : array) {
			min = Math.min(min, i);
		}
		return min;
	}

	// Time complexity is O(m*n * log(m*n)), because of sorting.
	// Space complexity is O(m*n).
}
