import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #323 (Number of Connected Components in an Undirected Graph).

// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge
// is a pair of nodes), write a function to find the number of connected components
// in an undirected graph.

public class NumberOfConnectedComponentsInAnUndirectedGraph {

	// Solution 1: Union find
	public int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			uf.union(edge[0], edge[1]);
		}
		return uf.count();
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).

	// Solution 2: DFS (adjacency list)
	public int countComponents2(int n, int[][] edges) {
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}
		int count = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (visited.add(i)) {
				count++;
				DFS(adjacencyList, visited, i);
			}
		}
		return count;
	}

	private void DFS(List<List<Integer>> adjacencyList, Set<Integer> visited, int cur) {
		visited.add(cur);
		for (int next : adjacencyList.get(cur)) {
			if (visited.add(next)) {
				DFS(adjacencyList, visited, next);
			}
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
