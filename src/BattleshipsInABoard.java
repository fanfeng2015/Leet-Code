// LeetCode #419 (Battleships in a Board).

// Given an 2D board, count how many battleships are in it. 
// The battleships are represented with 'X's, empty slots are represented with '.'s. 
// You may assume the following rules:

// 1. You receive a valid board, made of only battleships or empty slots.
// 2. Battleships can only be placed horizontally or vertically. In other words, they
//    can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), 
//    where N can be of any size.
// 3. At least one horizontal or vertical cell separates between two battleships - there
//    are no adjacent battleships.

public class BattleshipsInABoard {

	private int count;

	public int countBattleships(char[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					count++;
					DFS(board, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] board, int i, int j) {
		int m = board.length, n = board[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '.') {
			return;
		}
		board[i][j] = '.';
		DFS(board, i - 1, j);
		DFS(board, i + 1, j);
		DFS(board, i, j - 1);
		DFS(board, i, j + 1);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call stack.

	// Follow up:
	// Could you do it in one-pass, using O(1) extra space, and not modify the
	// original input matrix?
	public int countBattleships2(char[][] board) {
		int m = board.length, n = board[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
					count++;
				}
			}
		}
		return count;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).
}