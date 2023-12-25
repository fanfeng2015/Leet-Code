import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #1245 (Tree Diameter).

// The diameter of a tree is the number of edges in the longest path in that tree.

// There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1 and 
// edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.

// Return the diameter of the tree.

public class TreeDiameter {

	public int treeDiameter(int[][] edges) {
		if (edges == null || edges.length == 0) {
			return 0;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			map.putIfAbsent(edge[0], new ArrayList<>());
			map.putIfAbsent(edge[1], new ArrayList<>());
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		int destination = traverse(edges[0][0], map)[0];
		return traverse(destination, map)[1];
	}

	private int[] traverse(int start, Map<Integer, List<Integer>> map) {
		int destination = -1, level = -1;
		LinkedList<Integer> queue = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		queue.offerFirst(start);
		set.add(start);
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.pollLast();
				for (int neighbor : map.get(cur)) {
					if (set.add(neighbor)) {
						destination = neighbor;
						queue.offerFirst(neighbor);
					}
				}
			}
		}
		return new int[] { destination, level };
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
