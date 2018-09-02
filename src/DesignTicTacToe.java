// LeetCode #348 (Design Tic-Tac-Toe).

// Design a Tic-tac-toe game that is played between two players on a n x n grid.

// You may assume the following rules:
// 1. A move is guaranteed to be valid and is placed on an empty block.
// 2. Once a winning condition is reached, no more moves is allowed.
// 3. A player who succeeds in placing n of their marks in a horizontal, vertical,
//    or diagonal row wins the game.

public class DesignTicTacToe {

	// Increment for player 1, and decrement for player 2.
	int n;
	int[] rows, cols;
	int diagonal, reverseDiagonal;

	public DesignTicTacToe(int n) {
		this.n = n;
		this.rows = new int[n];
		this.cols = new int[n];
		this.diagonal = 0;
		this.reverseDiagonal = 0;
	}

	public int move(int row, int col, int player) {
		int diff = (player == 1) ? 1 : -1;
		rows[row] += diff;
		cols[col] += diff;
		diagonal += (row == col) ? diff : 0;
		reverseDiagonal += (row + col == n - 1) ? diff : 0;
		if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n
				|| Math.abs(reverseDiagonal) == n) {
			return player;
		}
		return 0;
	}

	// Time complexity is O(1).
	// Space complexity is O(n).
}
