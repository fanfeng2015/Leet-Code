import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

// LeetCode #734 (Sentence Similarity).

// Given two sentences words1, words2 (each represented as an array of strings), and a 
// list of similar word pairs pairs, determine if two sentences are similar.

public class SentenceSimilarity {

	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if (words1.length != words2.length) {
			return false;
		}
		Map<String, Set<String>> dict = new HashMap<>();
		for (String[] pair : pairs) {
			dict.putIfAbsent(pair[0], new HashSet<>());
			dict.putIfAbsent(pair[1], new HashSet<>());
			dict.get(pair[0]).add(pair[1]);
			dict.get(pair[1]).add(pair[0]);
		}
		for (int i = 0; i < words1.length; i++) {
			if ((!words1[i].equals(words2[i]))
					&& (!dict.containsKey(words1[i]) || !dict.get(words1[i]).contains(words2[i]))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(p + n).
	// Space complexity is O(p).
}
