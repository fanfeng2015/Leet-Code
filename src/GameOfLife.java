// LeetCode #289 (Game of Life).

// According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
// devised by the British mathematician John Horton Conway in 1970."

// Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with
// its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

// Any live cell with fewer than two live neighbors dies, as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population..
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

// Write a function to compute the next state (after one update) of the board given its current state. The next state is created
// by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

public class GameOfLife {

	int[][] directions = new int[][] { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },
			{ -1, -1 } };

	public void gameOfLife(int[][] board) {
		int m = board.length, n = board[0].length;
		int[][] M = copy(board);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int[] dir : directions) {
					int row = i + dir[0], col = j + dir[1];
					if (row >= 0 && row < m && col >= 0 && col < n) {
						count = (M[row][col] == 1) ? count + 1 : count;
					}
				}
				if (M[i][j] == 0) {
					board[i][j] = (count == 3) ? 1 : 0;
				} else if (M[i][j] == 1) {
					board[i][j] = (count == 2 || count == 3) ? 1 : 0;
				}
			}
		}
	}

	private int[][] copy(int[][] board) {
		int m = board.length, n = board[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = board[i][j];
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	// Follow-up: Could you solve it in-place?
	// Answer: Use the second least bit to store the next state,
	// In the first pass, compute the next state; in the second pass, shift all
	// values to the right by one bit.
}
