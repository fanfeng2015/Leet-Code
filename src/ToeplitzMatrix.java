// LeetCode #766 (Toeplitz Matrix).

// A matrix is Toeplitz if every diagonal from top-left to bottom-right has the 
// same element.

// Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

public class ToeplitzMatrix {

	public boolean isToeplitzMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) {
					return false;
				}
			}
		}
		return true;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).
}
