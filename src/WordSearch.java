// LeetCode #79 (Word Search).

// Given an m x n grid of characters board and a string word, return true if word exists in 
// the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent 
// cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

public class WordSearch {

	private static int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean[][] visited = new boolean[m][n];
					if (DFS(board, word, 0, i, j, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean DFS(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
		if (start == word.length()) {
			return true;
		}
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]
				|| board[row][col] != word.charAt(start)) {
			return false;
		}
		visited[row][col] = true;
		for (int[] direction : directions) {
			int newRow = row + direction[0], newCol = col + direction[1];
			if (DFS(board, word, start + 1, newRow, newCol, visited)) {
				return true;
			}
		}
		visited[row][col] = false;
		return false;
	}

	// Time complexity is O(m*n * 3^l), where l is the length of word.
	// Space complexity is O(l).

	// The reason for base 3 instead of base 4 is that one direction is already
	// visited in the parent recursive call, thus visited[i][j] is true.
}
