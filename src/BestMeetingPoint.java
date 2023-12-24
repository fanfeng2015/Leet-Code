import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// LeetCode #296 (Best Meeting Point).

// Given an m x n binary grid grid where each 1 marks the home of one friend, return the minimal total travel distance.

// The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

// The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

public class BestMeetingPoint {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int minTotalDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] count = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					bfs(i, j, grid, count);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				min = Math.min(min, count[i][j]);
			}
		}
		return min;
	}

	private void bfs(int row, int col, int[][] grid, int[][] count) {
		int m = grid.length, n = grid[0].length, level = 0;
		LinkedList<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		queue.offerFirst(new int[] { row, col });
		visited[row][col] = true;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cur = queue.pollLast();
				for (int[] dir : DIRECTIONS) {
					int nextRow = cur[0] + dir[0];
					int nextCol = cur[1] + dir[1];
					if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]) {
						queue.offerFirst(new int[] { nextRow, nextCol });
						visited[nextRow][nextCol] = true;
						count[nextRow][nextCol] += level;
					}
				}
			}
		}
	}

	// Time complexity is O(m^2 * n^2).
	// Space complexity is O(m*n), if we reuse queue and boolean matrix.

	public int minTotalDistance2(int[][] grid) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 1) {
					rows.add(row);
					cols.add(col);
				}
			}
		}
		Collections.sort(cols); // rows are already sorted
		int row = rows.get(rows.size() / 2);
		int col = cols.get(cols.size() / 2);
		return minDistance1D(rows, row) + minDistance1D(cols, col);
	}

	// As long as there is equal number of points to the left and right of the
	// meeting point, the total distance is minimized.
	private int minDistance1D(List<Integer> points, int origin) {
		int distance = 0;
		for (int point : points) {
			distance += Math.abs(point - origin);
		}
		return distance;
	}

	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n).
}
