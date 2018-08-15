import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #261 (Graph Valid Tree).

// Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a 
// pair of nodes), write a function to check whether these edges make up a valid tree.

public class GraphValidTree {

	// Solution 1: Union Find
	public boolean validTree(int n, int[][] edges) {
		int cur = n;
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
			if (cur - uf.count() == 0) { // cycle detected
				return false;
			}
			cur = uf.count();
		}
		return uf.count() == 1;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Solution 2: DFS (adjacency list)
	public boolean validTree2(int n, int[][] edges) {
		List<List<Integer>> adjacencyList = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}
		Set<Integer> visited = new HashSet<>();
		if (hasCycle(adjacencyList, visited, 0, -1)) {
			return false;
		}
		return visited.size() == n;
	}

	private boolean hasCycle(List<List<Integer>> adjacencyList, Set<Integer> visited, int cur, int parent) {
		visited.add(cur);
		for (int next : adjacencyList.get(cur)) {
			if ((visited.contains(next) && next != parent)
					|| (!visited.contains(next) && hasCycle(adjacencyList, visited, next, cur))) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	private static class UnionFind {

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
