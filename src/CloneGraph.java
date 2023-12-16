import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// LeetCode #133 (Clone Graph).

// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

public class CloneGraph {

	private class Node {
		public int val;
		public List<Node> neighbors;

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
	}

	// BFS
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		Map<Node, Node> map = new HashMap<>();
		queue.offer(node);
		map.put(node, new Node(node.val));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			Node copy = map.get(cur);
			for (Node neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor)) {
					queue.offer(neighbor);
					map.put(neighbor, new Node(neighbor.val));
				}
				copy.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}

	// Time complexity is O(|V|+|E|).
	// Space complexity is O(|V|+|E|).

	// DFS
	public Node cloneGraph2(Node node) {
		if (node == null) {
			return null;
		}
		Map<Node, Node> map = new HashMap<>();
		map.put(node, new Node(node.val));
		DFS(node, map);
		return map.get(node);
	}

	private void DFS(Node node, Map<Node, Node> map) {
		for (Node neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				map.put(neighbor, new Node(neighbor.val));
				DFS(neighbor, map);
			}
			map.get(node).neighbors.add(map.get(neighbor));
		}
	}

	// Time complexity is O(|V|+|E|).
	// Space complexity is O(|V|+|E|).
}
