import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LeetCode #399 (Evaluate Division).

// Equations are given in the format A / B = k, where A and B are variables
// represented as strings, and k is a real number (floating point number). 

// Given some queries, return the answers. If the answer does not exist, return -1.0.

public class EvaluateDivision {

	// Solution 1: DFS
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			graph.putIfAbsent(equation[0], new HashMap<>());
			graph.putIfAbsent(equation[1], new HashMap<>());
			graph.get(equation[0]).put(equation[1], values[i]);
			graph.get(equation[1]).put(equation[0], 1 / values[i]);
		}
		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			result[i] = DFS(graph, new HashSet<String>(), query[0], query[1], 1.0);
		}
		return result;
	}

	private double DFS(Map<String, Map<String, Double>> graph, Set<String> visited, String start, String end,
			double cur) {
		if (!graph.containsKey(start) || !visited.add(start)) {
			return -1;
		}
		if (start.equals(end)) {
			return cur;
		}
		Map<String, Double> next = graph.get(start);
		for (String str : next.keySet()) {
			double result = DFS(graph, visited, str, end, cur * next.get(str));
			if (result != -1) {
				return result;
			}
		}
		return -1;
	}

	// Solution 2: Union Find
	public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
		if (equations == null || equations.length == 0) {
			return new double[] {};
		}
		Map<String, String> parent = new HashMap<>(); // { node: parent }
		Map<String, Double> parentDivChild = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String x1 = equations[i][0], x2 = equations[i][1];
			parent.putIfAbsent(x1, x1);
			parent.putIfAbsent(x2, x2);
			parentDivChild.putIfAbsent(x1, 1.0);
			parentDivChild.putIfAbsent(x2, 1.0);

			String r1 = find(parent, x1);
			String r2 = find(parent, x2);
			parent.put(r2, r1); // r1 = parent of r2
			parentDivChild.put(r2, parentDivChild.get(x1) / parentDivChild.get(x2) * values[i]);
		}

		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = -1.0;
			String x1 = queries[i][0], x2 = queries[i][1];
			if (!parent.containsKey(x1) || !parent.containsKey(x2)) {
				continue;
			}
			String r1 = find(parent, x1);
			String r2 = find(parent, x2);
			if (r1.equals(r2)) {
				result[i] = compute(parent, parentDivChild, x2) / compute(parent, parentDivChild, x1);
			}
		}
		return result;
	}

	// Finds the root node of p.
	private String find(Map<String, String> parent, String p) {
		String root = p;
		while (!root.equals(parent.get(root))) {
			root = parent.get(root);
		}
		return root;
	}

	// Computes (root of p) / p.
	private double compute(Map<String, String> parent, Map<String, Double> map, String p) {
		String root = p;
		double result = map.get(root);
		while (!root.equals(parent.get(root))) {
			root = parent.get(root);
			result *= map.get(root);
		}
		return result;
	}

}
