// LeetCode #48 (Rotate Image).

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees 
// (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix
// directly. DO NOT allocate another 2D matrix and do the rotation.

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        flipAgainstY(matrix, n);
        flipAgainstYEqualsX(matrix, n);
    }

    private void flipAgainstY(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void flipAgainstYEqualsX(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; i + j < n - 1; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }

    private void swap(int[][] matrix, int iRow, int iCol, int jRow, int jCol) {
        int temp = matrix[iRow][iCol];
        matrix[iRow][iCol] = matrix[jRow][jCol];
        matrix[jRow][jCol] = temp;
    }
    
	// Time complexity is O(m*n).
	// Space complexity is O(1).
}
