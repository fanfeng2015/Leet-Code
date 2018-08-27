import java.util.ArrayList;
import java.util.List;

// LeetCode #305 (Number of Islands II).

// A 2d grid map of m rows and n columns is initially filled with water. 

// We may perform an addLand operation which turns the water at position 
// (row, col) into a land. Given a list of positions to operate, count the
// number of islands after each addLand operation. An island is surrounded
// by water and is formed by connecting adjacent lands horizontally or vertically. 

// You may assume all four edges of the grid are all surrounded by water.

public class NumberOfIslands2 {

	private int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public List<Integer> numIslands(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		char[][] grid = new char[m][n]; // default char is fine
		UnionFind unionFind = new UnionFind(grid);
		for (int[] position : positions) {
			int row = position[0];
			int col = position[1];
			grid[row][col] = '1'; // add land
			unionFind.add(row, col);
			for (int[] direction : directions) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
					unionFind.union(row * n + col, newRow * n + newCol);
				}
			}
			result.add(unionFind.count());
		}
		return result;
	}

	// Time complexity is O(k * log(m*n)).
	// Space complexity is O(m*n).
}