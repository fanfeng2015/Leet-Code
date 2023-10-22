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

	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public List<Integer> numIslands(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		int[][] grid = new int[m][n]; // default int is 0
		UnionFind unionFind = new UnionFind(grid);
		for (int[] position : positions) {
			int row = position[0];
			int col = position[1];
			grid[row][col] = 1; // add land
			unionFind.add(row, col);
			for (int[] direction : DIRECTIONS) {
				int newRow = row + direction[0];
				int newCol = col + direction[1];
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
					unionFind.union(row * n + col, newRow * n + newCol);
				}
			}
			result.add(unionFind.count());
		}
		return result;
	}

	// Time complexity is O(k * log(m*n)).
	// Space complexity is O(m*n).

	private class UnionFind {

		private int m;
		private int n;
		private int[] parent; // parent of i
		private int[] size; // size of the tree rooted at i

		private int count; // number of components

		public UnionFind(int[][] grid) {
			m = grid.length;
			n = grid[0].length;
			parent = new int[m * n];
			size = new int[m * n];
			// Note: There is no 1 in the grid initially.
		}

		public int count() {
			return count;
		}

		// add land operation
		public void add(int row, int col) {
			int index = row * n + col;
			parent[index] = index;
			size[index] = 1;
			count++;
		}

		public int find(int p) {
			validate(p);
			int root = p;
			while (root != parent[root]) {
				root = parent[root];
			}
			while (p != root) { // path compression to make tree flat
				int newParent = parent[root];
				parent[p] = root;
				p = newParent;
			}
			return root;
		}

		@SuppressWarnings("unused")
		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public void union(int p, int q) {
			int parentP = find(p);
			int parentQ = find(q);
			if (parentP == parentQ) {
				return;
			}
			// weighted quick union by size: make smaller root point to larger root
			if (size[parentP] < size[parentQ]) {
				parent[parentP] = parentQ;
				size[parentQ] += size[parentP];
			} else {
				parent[parentQ] = parentP;
				size[parentP] += size[parentQ];
			}
			count--;
		}

		private void validate(int p) {
			int n = parent.length;
			if (p < 0 || p >= n) {
				throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
			}
		}

		// Time complexity is O((m+n) * log(n)), on any m union-find operations
		// on a set of n objects.
	}
}