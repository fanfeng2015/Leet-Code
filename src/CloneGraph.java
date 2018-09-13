import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// LeetCode #133 (Clone Graph).

// Clone an undirected graph. Each node in the graph contains a label and a list of its
// neighbors.

public class CloneGraph {

	// BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		queue.offer(node);
		map.put(node, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			UndirectedGraphNode copy = map.get(cur);
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor)) {
					queue.offer(neighbor);
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
				}
				copy.neighbors.add(map.get(neighbor));
			}
		}
		return map.get(node);
	}

	// Time complexity is O(|V|+|E|).
	// Space complexity is O(|V|+|E|).

	// DFS
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, new UndirectedGraphNode(node.label));
		DFS(node, map);
		return map.get(node);
	}

	private void DFS(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				map.put(neighbor, new UndirectedGraphNode(neighbor.label));
				DFS(neighbor, map);
			}
			map.get(node).neighbors.add(map.get(neighbor));
		}
	}

	// Time complexity is O(|V|+|E|).
	// Space complexity is O(|V|+|E|).
}
