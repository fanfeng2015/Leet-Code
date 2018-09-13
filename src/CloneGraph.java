import java.util.HashMap;
import java.util.LinkedList;
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
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
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
}
