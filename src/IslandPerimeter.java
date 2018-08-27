// LeetCode #463 (Island Perimeter).

// You are given a map in form of a two-dimensional integer grid where 1 represents land and 
// 0 represents water. Grid cells are connected horizontally / vertically (not diagonally).

// The grid is completely surrounded by water, and there is exactly one island (i.e., one or 
// more connected land cells). The island doesn't have "lakes" (water inside that isn't connected
// to the water around the island). One cell is a square with side length 1. The grid is rectangular, 
// width and height don't exceed 100. Determine the perimeter of the island.

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					result += 4;
					result = (i < m - 1 && grid[i + 1][j] == 1) ? result - 2 : result;
					result = (j < n - 1 && grid[i][j + 1] == 1) ? result - 2 : result;
				}
			}
		}
		return result;
	}

	// Time complexity is O(m*n).
	// Space complexity is O(1).

	// Follow up: There are multiple islands, return the longest perimeter?
	
	// DFS. Need to create a copy of grid to keep track of visited cells. The
	// original grid will be used to determine how much the current perimeter should
	// be incremented.
}
