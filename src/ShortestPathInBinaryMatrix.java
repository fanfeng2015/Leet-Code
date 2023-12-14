import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #1091 (Shortest Path in Binary Matrix).

// Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, 
// return -1.

// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1))
// such that:
// - All the visited cells of the path are 0.
// - All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

// The length of a clear path is the number of visited cells of this path.

public class ShortestPathInBinaryMatrix {

	private static int[][] DIRECTIONS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
			{ 1, 0 }, { 1, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
			return -1;
		}
		grid[0][0] = 1;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offerFirst(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] cur = queue.pollLast();
			int row = cur[0], col = cur[1], length = grid[row][col];
			for (int[] neighbor : getNeighbors(grid, row, col)) {
				queue.offerFirst(new int[] { neighbor[0], neighbor[1] });
				grid[neighbor[0]][neighbor[1]] = length + 1;
			}
		}
		return grid[m - 1][n - 1] == 0 ? -1 : grid[m - 1][n - 1];
	}

	private List<int[]> getNeighbors(int[][] grid, int row, int col) {
		int m = grid.length, n = grid[0].length;
		List<int[]> neighbors = new ArrayList<>();
		for (int[] dir : DIRECTIONS) {
			int newRow = row + dir[0], newCol = col + dir[1];
			if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
				neighbors.add(new int[] { newRow, newCol });
			}
		}
		return neighbors;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}

// Note: We can also use a boolean[][] visited to avoid modifying the input matrix:
// 1. In case that multiple threads are reading/writing to the same input matrix.
// 2. In case the input matrix needs to be reused.