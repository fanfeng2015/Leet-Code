import java.util.ArrayList;
import java.util.List;

// LeetCode #311 (Sparse Matrix Multiplication).

// Given two sparse matrices A and B, return the result of AB.

// You may assume that A's column number is equal to B's row number.

public class SparseMatrixMultiplication {

	// Solution 1
	public int[][] multiply(int[][] A, int[][] B) {
		int rowA = A.length, colA = A[0].length;
		int rowB = B.length, colB = B[0].length;
		int[][] result = new int[rowA][colB];
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colA; j++) {
				if (A[i][j] != 0) {
					for (int k = 0; k < colB; k++) {
						if (B[j][k] != 0) {
							result[i][k] += A[i][j] * B[j][k];
						}
					}
				}
			}
		}
		return result;
	}

	// Time complexity is O(a*b*c).
	// Space complexity is O(1).

	// Solution 2
	private static class Cell {
		int col;
		int val;

		Cell(int col, int val) {
			this.col = col;
			this.val = val;
		}
	}

	public int[][] multiply2(int[][] A, int[][] B) {
		int rowA = A.length, colA = A[0].length;
		int rowB = B.length, colB = B[0].length;
		int[][] result = new int[rowA][colB];
		List[] lists = new List[rowA];
		for (int i = 0; i < rowA; i++) {
			List<Cell> cur = new ArrayList<>();
			for (int j = 0; j < colA; j++) {
				if (A[i][j] != 0) {
					cur.add(new Cell(j, A[i][j]));
				}
			}
			lists[i] = cur;
		}
		for (int i = 0; i < rowA; i++) {
			List<Cell> cur = lists[i];
			for (int j = 0; j < cur.size(); j++) {
				int col = cur.get(j).col;
				int val = cur.get(j).val;
				for (int k = 0; k < colB; k++) {
					result[i][k] += val * B[col][k];
				}
			}
		}
		return result;
	}

	// Time complexity is O(a*b + a*c), assuming each list has constant size.
	// Space complexity is O(a).

	// Follow up (Facebook): Sparse vector multiplication.
	// [ (index, value), ... ] for A and B respectively + two pointers.
}
