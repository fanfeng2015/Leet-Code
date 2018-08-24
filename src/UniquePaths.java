// LeetCode #62 (Unique Paths).

// A robot is located at the top-left corner of a m x n grid.
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid.

// How many possible unique paths are there?

public class UniquePaths {

	// C(n, k + 1) = C(n, k) * (n - k) / (k + 1)
	public int uniquePaths(int m, int n) {
		int a = m + n - 2, b = Math.min(m - 1, n - 1);
		long bCa = 1;
		for (int k = 0; k < b; k++) {
			bCa = bCa * (a - k) / (k + 1);
		}
		return (int) bCa;
	}

	// Time complexity is O(min(m, n)).
	// Space complexity is O(1).
}
