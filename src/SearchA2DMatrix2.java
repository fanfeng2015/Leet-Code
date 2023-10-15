// LeetCode #240 (Search a 2D Matrix II).

// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 

// This matrix has the following properties:
// 1. Integers in each row are sorted in ascending from left to right.
// 2. Integers in each column are sorted in ascending from top to bottom.

public class SearchA2DMatrix2 {

	// Solution 1: BFS + Heap
	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n).

	// Solution 2: Cut off row/col each time target is not found.
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0, col = matrix[0].length - 1; // start with the top right corner
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

	// Time complexity is O(m+n).
	// Space complexity is O(1).
}
