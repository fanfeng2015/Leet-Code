// LeetCode #750 (Number Of Corner Rectangles).

// Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

// A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. 

// Note that only the corners need to have the value 1. Also, all four 1s used must be 
// distinct.

public class NumberOfCornerRectangles {

	public int countCornerRectangles(int[][] grid) {
		int count = 0;
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				int cur = 0;
				for (int k = 0; k < n; k++) {
					if (grid[i][k] == 1 && grid[j][k] == 1) {
						cur++;
					}
				}
				count += (cur - 1) * cur / 2;
			}
		}
		return count;
	}

	// Time complexity is O(m * m * n).
	// Space complexity is O(1).
}
