// LeetCode #361 (Bomb Enemy).

// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
// return the maximum enemies you can kill using one bomb.

// The bomb kills all the enemies in the same row and column from the planted point until it 
// hits the wall since the wall is too strong to be destroyed.

// Note: You can only put the bomb at an empty cell.

public class BombEnemy {

	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length;
		Entry[][] entries = new Entry[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				entries[i][j] = new Entry();
				if (grid[i][j] == 'W') {
					continue;
				}
				int up = (i > 0) ? entries[i - 1][j].up : 0;
				int left = (j > 0) ? entries[i][j - 1].left : 0;
				entries[i][j].up = (grid[i][j] == 'E') ? up + 1 : up;
				entries[i][j].left = (grid[i][j] == 'E') ? left + 1 : left;
			}
		}
		int max = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 'W') {
					continue;
				}
				int down = (i < m - 1) ? entries[i + 1][j].down : 0;
				int right = (j < n - 1) ? entries[i][j + 1].right : 0;
				entries[i][j].down = (grid[i][j] == 'E') ? down + 1 : down;
				entries[i][j].right = (grid[i][j] == 'E') ? right + 1 : right;

				if (grid[i][j] == '0') {
					max = Math.max(max, entries[i][j].sum());
				}
			}
		}
		return max;
	}

	private class Entry {
		private int up, left, down, right;

		private int sum() {
			return up + left + down + right;
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
