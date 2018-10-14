// LeetCode #685 (Redundant Connection II).

// In this problem, a rooted tree is a directed graph such that, there is exactly one node 
// (the root) for which all other nodes are descendants of this node, plus every node has 
// exactly one parent, except for the root node which has no parents.

// The given input is a directed graph that started as a rooted tree with N nodes (with 
// distinct values 1, 2, ..., N), with one additional directed edge added. The added edge 
// has two different vertices chosen from 1 to N, and was not an edge that already existed.

// The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v]
// that represents a directed edge connecting nodes u and v, where u is a parent of child v.

// Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. 
// If there are multiple answers, return the answer that occurs last in the given 2D-array.

// Notes:
// 1. The size of the input 2D-array will be between 3 and 1000.
// 2. Every integer represented in the 2D-array will be between 1 and N, where N is the size
//    of the input array.

public class RedundantConnection2 {

	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		int[] candidateOne = { -1, -1 };
		int[] candidateTwo = { -1, -1 };
		int[] parent = new int[n + 1];
		// check whether there is a node with more than one parent
		for (int i = 0; i < edges.length; i++) {
			if (parent[edges[i][1]] == 0) {
				parent[edges[i][1]] = edges[i][0];
			} else { // already has a parent
				candidateOne = new int[] { parent[edges[i][1]], edges[i][1] };
				candidateTwo = new int[] { edges[i][0], edges[i][1] };
				edges[i][1] = 0; // remove edge candidateTwo
			}
		}
		// union find to check for cycles
		for (int i = 0; i < edges.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][1] == 0) { // removed candidateTwo
				continue;
			}
			int u = edges[i][0], v = edges[i][1];
			if (find(parent, u) == v) { // cycle found
				if (candidateOne[0] == -1) { // previously no node has more than one parent
					return edges[i];
				}
				return candidateOne;
			}
			parent[v] = u;
		}
		return candidateTwo; // no cycle found
	}

	// Finds root of p.
	private int find(int[] parent, int p) {
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
