// LeetCode #208 (Implement Trie (Prefix Tree)).

// Implement a trie with insert, search, and startsWith methods.

public class ImplementTrie {

	private TrieNode root;

	public ImplementTrie() {
		this.root = new TrieNode();
	}

	public void insert(String word) {
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
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (cur.children[ch - 'a'] == null) {
				return false;
			}
			cur = cur.children[ch - 'a'];
		}
		return cur.isWord;
	}

	public boolean startWith(String prefix) {
		TrieNode cur = root;
		for (char ch : prefix.toCharArray()) {
			if (cur.children[ch - 'a'] == null) {
				return false;
			}
			cur = cur.children[ch - 'a'];
		}
		return true;
	}

	// Time complexity is O(n) for all of insert(), search(), and startWith().
	// Space complexity is O(1).
}
