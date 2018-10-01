import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// LeetCode #785 (Is Graph Bipartite?).

// Given an undirected graph, return true if and only if it is bipartite.

public class IsGraphBipartite {

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		Map<Integer, Integer> visited = new HashMap<>(); // { node: group }
		for (Integer i = 0; i < n; i++) {
			if (!validate(i, visited, graph)) {
				return false;
			}
		}
		return true;
	}

	private boolean validate(Integer node, Map<Integer, Integer> visited, int[][] graph) {
		if (visited.containsKey(node)) {
			return true;
		}
		visited.put(node, 0);
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offerFirst(node);
		while (!queue.isEmpty()) {
			Integer cur = queue.pollLast();
			for (Integer neighbor : graph[cur]) {
				if (!visited.containsKey(neighbor)) {
					visited.put(neighbor, 1 - visited.get(cur));
					queue.offerFirst(neighbor);
				} else if (visited.get(neighbor) == visited.get(cur)) {
					return false;
				}
			}
		}
		return true;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(n).
}
