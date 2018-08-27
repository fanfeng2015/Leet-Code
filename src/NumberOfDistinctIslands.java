import java.util.HashSet;
import java.util.Set;

// LeetCode #694 (Number of Distinct Islands).

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
// connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid 
// are surrounded by water.

// Count the number of distinct islands.An island is considered to be the same as another if and 
// only if one island can be translated(and not rotated or reflected)to equal the other.

public class NumberOfDistinctIslands {

	private int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numDistinctIslands(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int count = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					DFS(grid, i, j, i, j, sb);
					if (set.add(sb.toString())) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private void DFS(int[][] grid, int startRow, int startCol, int curRow, int curCol, StringBuilder sb) {
		int m = grid.length, n = grid[0].length;
		if (curRow >= 0 && curRow < m && curCol >= 0 && curCol < n && grid[curRow][curCol] == 1) {
			grid[curRow][curCol] = 0;
			sb.append(curRow - startRow).append(curCol - startCol);
			for (int[] direction : directions) {
				DFS(grid, startRow, startCol, curRow + direction[0], curCol + direction[1], sb);
			}
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call-stack.
}
