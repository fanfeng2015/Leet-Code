import java.util.LinkedList;

// LeetCode #317 (Shortest Distance from All Buildings).

// You are given an m x n grid grid of values 0, 1, or 2, where:
// - each 0 marks an empty land that you can pass by freely,
// - each 1 marks a building that you cannot pass through, and
// - each 2 marks an obstacle that you cannot pass through.

// You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move 
// up, down, left, and right.

// Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, 
// return -1.

// The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

// The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

public class ShortestDistanceFromAllBuildings {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int shortestDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int count = 0; // number of buildings
		int[][] distance = new int[m][n]; // sum of distances from all buildings to (i, j)
		int[][] reach = new int[m][n]; // number of buildings that can reach (i, j)
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count++;
					BFS(grid, distance, reach, new boolean[m][n], i, j);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				min = Math.min(min, (reach[i][j] == count) ? distance[i][j] : Integer.MAX_VALUE);
			}
		}
		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	private void BFS(int[][] grid, int[][] distance, int[][] reach, boolean[][] visited, int row, int col) {
		int m = grid.length, n = grid[0].length;
		int cur = 0;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offerFirst(new int[] { row, col });
		while (!queue.isEmpty()) {
			cur++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] position = queue.pollLast();
				for (int[] direction : DIRECTIONS) {
					int nextRow = position[0] + direction[0], nextCol = position[1] + direction[1];
					if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0
							&& !visited[nextRow][nextCol]) {
						distance[nextRow][nextCol] += cur;
						reach[nextRow][nextCol]++;
						visited[nextRow][nextCol] = true;
						queue.offerFirst(new int[] { nextRow, nextCol });
					}
				}
			}
		}
	}

	// Time complexity is O(m*n * m*n).
	// Space complexity is O(m*n).
}
