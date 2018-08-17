// LeetCode #304 (Range Sum Query 2D - Immutable).

// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by
// its upper left corner (row1, col1) and lower right corner (row2, col2).

// Notes:
// 1. You may assume that the matrix does not change.
// 2. There are many calls to sumRegion function.
// 3. You may assume that row1 ≤ row2 and col1 ≤ col2.

public class RangeSumQuery2DImmutable {

	int[][] matrix;

	public RangeSumQuery2DImmutable(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int left = (i > 0) ? matrix[i - 1][j] : 0;
				int top = (j > 0) ? matrix[i][j - 1] : 0;
				int extra = (i > 0 && j > 0) ? matrix[i - 1][j - 1] : 0;
				matrix[i][j] += left + top - extra;
			}
		}
		this.matrix = matrix;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int left = (col1 > 0) ? matrix[row2][col1 - 1] : 0;
		int top = (row1 > 0) ? matrix[row1 - 1][col2] : 0;
		int missing = (row1 > 0 && col1 > 0) ? matrix[row1 - 1][col1 - 1] : 0;
		return matrix[row2][col2] - left - top + missing;
	}

	// Time complexity is O(m*n) to construct and O(1) to query.
	// Space complexity is O(1).
}
