import java.util.LinkedList;

// LeetCode #529 (Minesweeper).

// Let's play the minesweeper game (Wikipedia, online game)!

// You are given an m x n char matrix board representing the game board where:

// - 'M' represents an unrevealed mine,
// - 'E' represents an unrevealed empty square,
// - 'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
// - digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
// - 'X' represents a revealed mine.

// You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the 
// unrevealed squares ('M' or 'E').

// Return the board after revealing this position according to the following rules:
// - If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
// - If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent 
//   unrevealed squares should be revealed recursively.
// - If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the
//   number of adjacent mines.
// - Return the board when no more squares will be revealed.

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
