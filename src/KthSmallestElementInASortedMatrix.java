import java.util.Comparator;
import java.util.PriorityQueue;

// LeetCode #378 (Kth Smallest Element in a Sorted Matrix).

// Given a n x n matrix where each of the rows and columns are sorted in ascending 
// order, find the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct
// element.

public class KthSmallestElementInASortedMatrix {

	// Solution 1: BFS + Heap
	// Option 1: Let class Cell implement Comparable<Cell>.
	// Option 2: Let PriorityQueue<Cell> take a Comparator.
	private class Cell {
		int row;
		int col;
		int value;

		Cell(int row, int col, int value) {
			this.row = row;
			this.col = col;
			this.value = value;
		}
	}

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.value == c2.value) {
					return 0;
				}
				return c1.value < c2.value ? -1 : 1;
			}
		});
		int row = matrix.length, col = matrix[0].length;
		boolean[][] marked = new boolean[row][col];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		marked[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cell = minHeap.poll();
			if (cell.row < row - 1 && !marked[cell.row + 1][cell.col]) {
				minHeap.offer(new Cell(cell.row + 1, cell.col, matrix[cell.row + 1][cell.col]));
				marked[cell.row + 1][cell.col] = true;
			}
			if (cell.col < col - 1 && !marked[cell.row][cell.col + 1]) {
				minHeap.offer(new Cell(cell.row, cell.col + 1, matrix[cell.row][cell.col + 1]));
				marked[cell.row][cell.col + 1] = true;
			}
		}
		return minHeap.poll().value;
	}

	// Time complexity is O(k*log(k)).
	// Space complexity is O(k + m*n) = O(m*n).

	// Solution 2: Binary search
	public int kthSmallest2(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int low = matrix[0][0], high = matrix[m - 1][n - 1];
		while (low < high) {
			int mid = low + (high - low) / 2;
			// for each row, binary search to find how many elements are < mid
			int count = 0;
			for (int i = 0; i < m; i++) {
				count += countSmallerOrEqual(matrix[i], mid);
			}
			if (count < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private int countSmallerOrEqual(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int left = 0, right = array.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	// Time complexity is O(m*log(n)*log(N)), N = Integer.MAX_VALUE;
	// Space complexity is O(1).
}
