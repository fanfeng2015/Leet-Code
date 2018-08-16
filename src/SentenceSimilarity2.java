import java.util.HashMap;
import java.util.Map;

// LeetCode #737 (Sentence Similarity II).

// Given two sentences words1, words2 (each represented as an array of strings), and a list of 
// similar word pairs, determine if two sentences are similar.

public class SentenceSimilarity2 {

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		int n = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String[] pair : pairs) {
			if (!map.containsKey(pair[0])) {
				map.put(pair[0], n++);
			}
			if (!map.containsKey(pair[1])) {
				map.put(pair[1], n++);
			}
		}
		UnionFind uf = new UnionFind(n);
		for (String[] pair : pairs) {
			uf.union(map.get(pair[0]), map.get(pair[1]));
		}
		for (int i = 0; i < words1.length; i++) {
			if (!words1[i].equals(words2[i])) {
				Integer index1 = map.get(words1[i]);
				Integer index2 = map.get(words2[i]);
				if (index1 == null || index2 == null || !uf.connected(index1, index2)) {
					return false;
				}
			}
		}
		return true;
	}

	// Time complexity is O(p*log(p) + n).
	// Space complexity is O(p).

	// Implementation of the Union Find data structure, using weighted quick union
	// (by size) with full path compression.

	// See
	// https://algs4.cs.princeton.edu/15uf/WeightedQuickUnionPathCompressionUF.java.html
	// for the original implementation.

	private class UnionFind {

		private int[] parent; // parent of i
		private int[] size; // size of the tree rooted at i

		private int count; // number of components

		public UnionFind(int n) {
			count = n;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public int count() {
			return count;
		}

		public int find(int p) {
			validate(p);
			int root = p;
			while (root != parent[root]) {
				root = parent[root];
			}
			while (p != root) { // path compression to make tree flat
				int newParent = parent[root];
				parent[p] = root;
				p = newParent;
			}
			return root;
		}

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public void union(int p, int q) {
			int parentP = find(p);
			int parentQ = find(q);
			if (parentP == parentQ) {
				return;
			}
			// weighted quick union by size: make smaller root point to larger root
			if (size[parentP] < size[parentQ]) {
				parent[parentP] = parentQ;
				size[parentQ] += size[parentP];
			} else {
				parent[parentQ] = parentP;
				size[parentP] += size[parentQ];
			}
			count--;
		}

		private void validate(int p) {
			int n = parent.length;
			if (p < 0 || p >= n) {
				throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
			}
		}

		// Time complexity is O((m+n) * log(n)), on any m union-find operations
		// on a set of n objects.
	}

}
