
// LeetCode #211 (Add and Search Word - Data structure design).

// Design a data structure that supports the following two operations:
// void addWord(word)
// bool search(word)

// search(word) can search a literal word or a regular expression string 
// containing only letters a-z or .. 

// A . means it can represent any one letter.

public class AddAndSearchWord {

	TrieNode root = new TrieNode();

	public AddAndSearchWord() {

	}

	public void addWord(String word) {
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.children[ch - 'a'] == null) {
				cur.children[ch - 'a'] = new TrieNode();
			}
			cur = cur.children[ch - 'a'];
		}
		cur.isWord = true;
	}

	public boolean search(String word) {
		return search(word, 0, root);
	}

	private boolean search(String word, int level, TrieNode cur) {
		if (level == word.length()) {
			return cur.isWord;
		}
		if (word.charAt(level) != '.') {
			if (cur.children[word.charAt(level) - 'a'] == null) {
				return false;
			} else {
				return search(word, level + 1, cur.children[word.charAt(level) - 'a']);
			}
		} else {
			for (int i = 0; i < 26; i++) {
				if (cur.children[i] != null && search(word, level + 1, cur.children[i])) {
					return true;
				}
			}
		}
		return false;
	}

	private static class TrieNode {
		int n = 26;
		boolean isWord;
		TrieNode[] children = new TrieNode[n];
	}

}