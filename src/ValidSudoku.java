// LeetCode #36 (Valid Sudoku).

// Determine if a Sudoku is valid.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

public class ValidSudoku {

	private static int n = 9;

	public boolean isValidSudoku(char[][] board) {
		// (group, number): whether number exists in group
		boolean[][] rows = new boolean[n][n], cols = new boolean[n][n], blocks = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int k = (i / 3) * 3 + j / 3;
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]) - 1;
					if (rows[i][num] || cols[j][num] || blocks[k][num]) {
						return false;
					}
					rows[i][num] = cols[j][num] = blocks[k][num] = true;
				}
			}
		}
		return true;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2).
}
