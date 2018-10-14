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
		Map<String, String> parent = new HashMap<>(); // a / b = 2.0, { a: b }
		Map<String, Double> weight = new HashMap<>(); // a / b = 2.0, { a: 2.0 }
		for (int i = 0; i < equations.length; i++) {
			String[] equation = equations[i];
			String a = equation[0], b = equation[1];
			double value = values[i];
			
		}
	}
	
	// Finds the root node of str
	private String find(Map<String, String> parent, Map<String, Double> weight) {

	}
	
//	private class Node {
//		String label; // 
//		double value; // root.label / label = value; 
//		public Node(String label, double value) {
//			this.label = label;
//			this.value = value;
//		}
//	}

	
}


