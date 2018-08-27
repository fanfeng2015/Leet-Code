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
}
