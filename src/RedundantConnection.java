// LeetCode #684 (Redundant Connection).

// In this problem, a tree is an undirected graph that is connected and has no cycles.

// The given input is a graph that started as a tree with N nodes (with distinct values
// 1, 2, ..., N), with one additional edge added. The added edge has two different vertices
// chosen from 1 to N, and was not an edge that already existed.

// The resulting graph is given as a 2D-array of edges. Each element of edges is a pair 
// [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

// Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
// If there are multiple answers, return the answer that occurs last in the given 2D-array. 
// The answer edge [u, v] should be in the same format, with u < v.

// Notes:
// 1. The size of the input 2D-array will be between 3 and 1000.
// 2. Every integer represented in the 2D-array will be between 1 and N, where N is the size
//    of the input array.

public class RedundantConnection {

	private static final int LIMIT = 1001;

	public int[] findRedundantConnection(int[][] edges) {
		UnionFind uf = new UnionFind(LIMIT);
		for (int[] edge : edges) {
			if (uf.connected(edge[0], edge[1])) {
				return edge;
			}
			uf.union(edge[0], edge[1]);
		}
		return new int[] { -1, -1 };
	}

	private class UnionFind {

		private int[] parent; // parent of i
		private int[] size; // size of the tree rooted at i

		private int count; // number of components

		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
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
