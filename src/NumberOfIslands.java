// LeetCode #200 (Number of Islands).

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
// four edges of the grid are all surrounded by water.

public class NumberOfIslands {

	// Solution 1: DFS
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int row = grid.length, col = grid[0].length, count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					count++;
					DFS(grid, i, j);
				}
			}
		}
		return count;
	}

	private void DFS(char[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
			return;
		}
		grid[row][col] = '0';
		DFS(grid, row - 1, col);
		DFS(grid, row + 1, col);
		DFS(grid, row, col - 1);
		DFS(grid, row, col + 1);
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), because of call stack.

	// Solution 2: Union Find
	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numIslands2(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		UnionFind unionFind = new UnionFind(grid);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					for (int[] direction : DIRECTIONS) {
						int row = i + direction[0];
						int col = j + direction[1];
						if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
							unionFind.union(i * n + j, row * n + col);
						}
					}
				}
			}
		}
		return unionFind.count();
	}

	// Time complexity is O(m*n * log(m*n)).
	// Space complexity is O(m*n), but on heap instead of stack.

	// Follow up: LeetCode #305 (Number of Islands II).

	private class UnionFind {

		private int[] parent; // parent of i
		private int[] size; // size of the tree rooted at i

		private int count; // number of components

		public UnionFind(char[][] grid) {
			int m = grid.length, n = grid[0].length;
			parent = new int[m * n];
			size = new int[m * n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						int index = i * n + j;
						parent[index] = index;
						size[index] = 1;
						count++;
					}

				}
			}
		}

		public int count() {
			return count;
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

		// Time complexity is O(m*log(n)), on any m union-find operations on a set of n
		// objects.
	}

}
