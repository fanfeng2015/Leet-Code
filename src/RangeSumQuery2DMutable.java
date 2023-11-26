// LeetCode #308 (Range Sum Query 2D - Mutable).

// Given a 2D matrix matrix, handle multiple queries of the following types:

// - Update the value of a cell in matrix.
// - Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower 
//   right corner (row2, col2).

// Implement the NumMatrix class:
// - NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
// - void update(int row, int col, int val) Updates the value of matrix[row][col] to be val.
// - int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle 
//   defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

public class RangeSumQuery2DMutable {

	int m, n;
	int[][] nums;
	int[][] bit;

	public RangeSumQuery2DMutable(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		m = matrix.length;
		n = matrix[0].length;
		nums = new int[m][n];
		bit = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {
		int diff = val - nums[row][col];
		nums[row++][col++] = val;
		while (row <= m) {
			int cur = col;
			while (cur <= n) {
				bit[row][cur] += diff;
				cur += cur & (-cur);
			}
			row += row & (-row);
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return findSum(row2, col2) - findSum(row1 - 1, col2) - findSum(row2, col1 - 1) + findSum(row1 - 1, col1 - 1);

	}

	private int findSum(int row, int col) {
		int sum = 0;
		row++;
		col++;
		while (row > 0) {
			int cur = col;
			while (cur > 0) {
				sum += bit[row][cur];
				cur -= cur & (-cur);
			}
			row -= row & (-row);
		}
		return sum;
	}

	// Time complexity is O(m * n * log(m) * log(n)) to construct the binary indexed
	// tree and O(log(m) * log(n)) to update and to query.
	// Space complexity is O(m * n).
}