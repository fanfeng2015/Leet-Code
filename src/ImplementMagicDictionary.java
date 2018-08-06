import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// LeetCode #676 (Implement Magic Dictionary).

// Implement a magic directory with buildDict, and search methods.

// For the method buildDict, you'll be given a list of non-repetitive
// words to build a dictionary.

// For the method search, you'll be given a word, and judge whether if
// you modify exactly one character into another character in this word,
// the modified word is in the dictionary you just built.

public class ImplementMagicDictionary {

	Map<Integer, HashSet<String>> map;

	public ImplementMagicDictionary() {
		map = new HashMap<>();
	}

	public void buildDict(String[] dict) {
		for (String word : dict) {
			HashSet<String> set = map.get(word.length());
			set = (set == null) ? new HashSet<>() : set;
			set.add(word);
			map.put(word.length(), set);
		}
	}

	public boolean search(String word) {
		if (!map.containsKey(word.length())) {
			return false;
		}
		for (String candidate : map.get(word.length())) {
			int difference = 0;
			for (int i = 0; i < word.length(); i++) {
				if (candidate.charAt(i) != word.charAt(i)) {
					difference++;
				}
				if (difference > 1) {
					break;
				}
			}
			if (difference == 1) {
				return true;
			}
		}
		return false;
	}

	// n: size of dictionary, k: length of dictionary word, l: length of search word

	// Time complexity is O(n*k) to build dictionary, O(n*l) to search word.
	// Space complexity is O(n*k).

}
