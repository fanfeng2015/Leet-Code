// LeetCode #74 (Search a 2D Matrix).

// You are given an m x n integer matrix matrix with the following two properties:
//   -- Each row is sorted in non-decreasing order.
//   -- The first integer of each row is greater than the last integer of the previous row.

// Given an integer target, return true if target is in matrix or false otherwise.

public class SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m * n - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int row = mid / n, col = mid % n;
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return matrix[left / n][left % n] == target;
	}

	// Time complexity is O(log(m*n)).
	// Space complexity is O(1).
}
