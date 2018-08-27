import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #261 (Graph Valid Tree).

// Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a 
// pair of nodes), write a function to check whether these edges make up a valid tree.

public class GraphValidTree {

	// Solution 1: Union find
	public boolean validTree(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			if (uf.connected(edge[0], edge[1])) { // cycle detected
				return false;
			}
			uf.union(edge[0], edge[1]);
		}
		return uf.count() == 1;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Solution 2: DFS (adjacency list)
	public boolean validTree2(int n, int[][] edges) {
		List<List<Integer>> adjacencyList = new ArrayList<>();
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
}
