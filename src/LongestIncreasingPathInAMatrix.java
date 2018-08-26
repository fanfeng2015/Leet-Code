// LeetCode #329 (Longest Increasing Path in a Matrix).

// Given an integer matrix, find the length of the longest increasing path.

// From each cell, you can either move to four directions: left, right, up or down. 

// You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is
// not allowed).

public class LongestIncreasingPathInAMatrix {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int m = matrix.length, n = matrix[0].length;
		int[][] memoization = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, DFS(matrix, memoization, i, j));
			}
		}
		return max;
	}

	// Returns length of the longest increasing path starting from (i, j).
	private int DFS(int[][] matrix, int[][] memoization, int i, int j) {
		int m = matrix.length, n = matrix[0].length;
		if (memoization[i][j] != 0) {
			return memoization[i][j];
		}
		for (int[] dir : DIRECTIONS) {
			int x = i + dir[0], y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
				memoization[i][j] = Math.max(memoization[i][j], DFS(matrix, memoization, x, y));
			}
		}
		return ++memoization[i][j];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
