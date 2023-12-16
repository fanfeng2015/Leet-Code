// LeetCode #348 (Design Tic-Tac-Toe).

// Assume the following rules are for the tic-tac-toe game on an n x n board between two players:
// - A move is guaranteed to be valid and is placed on an empty block.
// - Once a winning condition is reached, no more moves are allowed.
// - A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

// Implement the TicTacToe class:
// - TicTacToe(int n) Initializes the object the size of the board n.
// - int move(int row, int col, int player) Indicates that the player with id player plays at the cell (row, col) of the board. The 
//   move is guaranteed to be a valid move, and the two players alternate in making moves. Return
//   - 0 if there is no winner after the move,
//   - 1 if player 1 is the winner after the move, or
//   - 2 if player 2 is the winner after the move.

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
