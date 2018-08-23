import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// LeetCode #773 (Sliding Puzzle).

// On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty 
// square represented by 0.

// A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

// The state of the board is solved if and only if the board is [[1, 2, 3], [4, 5, 0]].

// Given a puzzle board, return the least number of moves required so that the state of the
// board is solved. If it is impossible for the state of the board to be solved, return -1.

public class SlidingPuzzle {

	private static final int NUM_ROW = 2;
	private static final int NUM_COL = 3;
	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int slidingPuzzle(int[][] board) {
		String target = Arrays.deepToString(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } });
		if (Arrays.deepToString(board).equals(target)) {
			return 0;
		}
		LinkedList<Cell> queue = new LinkedList<>();
		queue.offerFirst(findStartingPoint(board));
		Set<String> visited = new HashSet<>();
		visited.add(queue.peekLast().representation);
		int step = 0; // have moved this many steps
		while (!queue.isEmpty()) {
			int size = queue.size();
			step++;
			for (int i = 0; i < size; i++) {
				Cell cur = queue.pollLast();
				for (int[] dir : DIRECTIONS) {
					if (!outOfBound(cur.zeroRow + dir[0], cur.zeroCol + dir[1])) {
						int[][] copyBoard = copy(cur.board);
						swap(copyBoard, cur.zeroRow + dir[0], cur.zeroCol + dir[1], cur.zeroRow, cur.zeroCol);
						if (Arrays.deepToString(copyBoard).equals(target)) {
							return step;
						}
						if (!visited.contains(Arrays.deepToString(copyBoard))) {
							visited.add(Arrays.deepToString(copyBoard));
							queue.offerFirst(new Cell(copyBoard, cur.zeroRow + dir[0], cur.zeroCol + dir[1]));
						}
					}
				}
			}
		}
		return -1;
	}

	private Cell findStartingPoint(int[][] board) {
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					return new Cell(board, i, j);
				}
			}
		}
		return new Cell(board, -1, -1); // should never reach here
	}

	private boolean outOfBound(int row, int col) {
		return row < 0 || row >= NUM_ROW || col < 0 || col >= NUM_COL;
	}

	private int[][] copy(int[][] board) {
		int m = board.length, n = board[0].length;
		int[][] copy = new int[m][n];
		for (int i = 0; i < m; i++) {
			copy[i] = board[i].clone();
		}
		return copy;
	}

	private void swap(int[][] board, int row1, int col1, int row2, int col2) {
		int temp = board[row1][col1];
		board[row1][col1] = board[row2][col2];
		board[row2][col2] = temp;
	}

	private class Cell {
		int[][] board;
		int zeroRow;
		int zeroCol;
		String representation; // Trick: Don't need to override hashCode() and equals()

		Cell(int[][] board, int zeroRow, int zeroCol) {
			this.board = board;
			this.zeroRow = zeroRow;
			this.zeroCol = zeroCol;
			this.representation = Arrays.deepToString(board);
		}
	}

	// Time complexity is O(m * n * (m*n)!) since there (m*n)! states.
	// Space complexity is O(m * n * (m*n)!).
}
