// LeetCode #308 (Range Sum Query 2D - Mutable).

// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
// by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Notes:
// 1. The matrix is only modifiable by the update function.
// 2. You may assume the number of calls to update and sumRegion function is distributed evenly.
// 3. You may assume that row1 ≤ row2 and col1 ≤ col2.

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

}