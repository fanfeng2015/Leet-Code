import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// LeetCode #676 (Implement Magic Dictionary).

// Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can
// change exactly one character in this string to match any word in the data structure.

// Implement the MagicDictionary class:
// - MagicDictionary() Initializes the object.
// - void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
// - bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the
//   data structure, otherwise returns false.

public class ImplementMagicDictionary {

	// Solution 1
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

	// Time complexity is O(n) to build dictionary, O(n*l) to search word.
	// Space complexity is O(n*k).

	// Solution 2: Trie
	TrieNode root = new TrieNode();

	public void buildDict2(String[] dict) {
		for (String word : dict) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				if (cur.children[word.charAt(i) - 'a'] == null) {
					cur.children[word.charAt(i) - 'a'] = new TrieNode();
				}
				cur = cur.children[word.charAt(i) - 'a'];
			}
			cur.isWord = true;
		}
	}

	public boolean search2(String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			for (int j = 0; j < 26; j++) { // modify the i-th char to every possible char
				if ((char) ('a' + j) != ch && cur.children[j] != null && search2(word, i + 1, cur.children[j])) {
					return true;
				}
			}
			// so far, modification of the i-th char doesn't lead to an existing word in
			// the dict
			// - if no other word starts with this prefix, then target can't be found
			// - otherwise, we can keep the current character, and alter a future character
			if (cur.children[ch - 'a'] == null) {
				return false;
			}
			cur = cur.children[ch - 'a'];
		}
		return false;
	}

	// Modification has been made at (index - 1), an exact match for the rest of the
	// word needs to be found.
	private boolean search2(String word, int index, TrieNode node) {
		TrieNode cur = node;
		for (int i = index; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (cur.children[ch - 'a'] == null) {
				return false;
			}
			cur = cur.children[ch - 'a'];
		}
		return cur.isWord;
	}

	// Time complexity is O(n*k) to build dictionary, O(l) to search word.
	// Space complexity is O(n*k).
}
