import java.util.LinkedList;

// LeetCode #529 (Minesweeper).

public class MineSweeper {

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 }, { 0, -1 }, { -1, -1 } };

	// Only need to change 'E', do nothing if 'M', 'B', '1' ~ '8', or 'X'.
	public char[][] updateBoard(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
		}
		if (board[click[0]][click[1]] != 'E') {
			return board;
		}
		board[click[0]][click[1]] = 'B';
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offerFirst(click);
		while (!queue.isEmpty()) {
			int[] cur = queue.pollLast(); // must previously be 'E' and now be 'B'
			int row = cur[0], col = cur[1];
			// check surroundings for 'M' or 'X'
			int count = 0;
			for (int[] dir : DIRECTIONS) {
				int nextRow = row + dir[0], nextCol = col + dir[1];
				if (!outOfBound(nextRow, nextCol, m, n)
						&& (board[nextRow][nextCol] == 'M' || board[nextRow][nextCol] == 'X')) {
					count++;
				}
			}
			if (count == 0) {
				// add nearby cells
				for (int[] dir : DIRECTIONS) {
					int nextRow = row + dir[0], nextCol = col + dir[1];
					// can't be 'M' or 'X', otherwise count > 0
					if (!outOfBound(nextRow, nextCol, m, n) && (board[nextRow][nextCol] == 'E')) {
						board[nextRow][nextCol] = 'B'; // Trick: avoid duplicate
						queue.offerFirst(new int[] { nextRow, nextCol });
					}
				}
			} else {
				board[row][col] = (char) ('0' + count);
			}

		}
		return board;
	}

	// Note:
	// Set<int[]> set = new HashSet<>();
	// set.add(new int[] { 1, 2, 3 });
	// set.add(new int[] { 1, 2, 3 }); // true

	private boolean outOfBound(int row, int col, int m, int n) {
		return row < 0 || row >= m || col < 0 || col >= n;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).
}
