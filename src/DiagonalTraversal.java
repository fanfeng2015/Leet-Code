import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// LeetCode #498 (Diagonal Traverse).

// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

public class DiagonalTraversal {

	public int[] findDiagonalOrder(int[][] mat) {
		int m = mat.length, n = mat[0].length, index = 0;
		int[] result = new int[m * n];
		List<LinkedList<Integer>> lists = new ArrayList<>(); // even: stack; odd: queue
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int group = i + j;
				if (group >= lists.size()) {
					lists.add(new LinkedList<>());
				}
				lists.get(group).offerFirst(mat[i][j]);
			}
		}
		for (int i = 0; i < lists.size(); i++) {
			int size = lists.get(i).size();
			for (int j = 0; j < size; j++) {
				result[index++] = (i % 2 == 0) ? lists.get(i).pollFirst() : lists.get(i).pollLast();
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n).

	public int[] findDiagonalOrder2(int[][] mat) {
		int m = mat.length, n = mat[0].length, row = 0, col = 0;
		int[] result = new int[m * n];
		for (int i = 0; i < m * n; i++) {
			result[i] = mat[row][col];
			if ((row + col) % 2 == 0) { // going up
				if (col == n - 1) {
					row++;
				} else if (row == 0) {
					col++;
				} else {
					row--;
					col++;
				}
			} else { // going down
				if (row == m - 1) {
					col++;
				} else if (col == 0) {
					row++;
				} else {
					row++;
					col--;
				}
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).
}
