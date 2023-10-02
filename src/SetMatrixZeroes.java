// LeetCode #73 (Set Matrix Zeroes).

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column 
// to 0's.

// You must do it in place.

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		boolean firstRow = false, firstCol = false;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					firstRow = i == 0 ? true : firstRow;
					firstCol = j == 0 ? true : firstCol;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				matrix[i][j] = (matrix[i][0] == 0 || matrix[0][j] == 0) ? 0 : matrix[i][j];
			}
		}
		if (firstRow) {
			for (int i = 0; i < cols; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstCol) {
			for (int i = 0; i < rows; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).		
}
