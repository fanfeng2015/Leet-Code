// LeetCode #807 (Max Increase to Keep City Skyline).

// In a 2 dimensional array grid, each value grid[i][j] represents the height of a building
// located there. We are allowed to increase the height of any number of buildings, by any 
// amount (the amounts can be different for different buildings). Height 0 is considered to
// be a building as well. 

// At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, 
// bottom, left, and right, must be the same as the skyline of the original grid. A city's 
// skyline is the outer contour of the rectangles formed by all the buildings when viewed 
// from a distance. See the following example.

// What is the maximum total sum that the height of the buildings can be increased?

// Notes:
// 1. 1 < grid.length = grid[0].length <= 50.
// 2. All heights grid[i][j] are in the range [0, 100].
// 3. All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 
//    1 x 1 x grid[i][j] rectangular prism.

public class MaxIncreaseToKeepCitySkyline {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] leftRight = new int[m], topBottom = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				leftRight[i] = Math.max(leftRight[i], grid[i][j]);
				topBottom[j] = Math.max(topBottom[j], grid[i][j]);
			}
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count += Math.min(leftRight[i], topBottom[j]) - grid[i][j];
			}
		}
		return count;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m + n).
}
