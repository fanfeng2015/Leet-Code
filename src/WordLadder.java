import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #127 (Word Ladder).

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words 
// beginWord -> s1 -> s2 -> ... -> sk such that:
// - Every adjacent pair of words differs by a single letter.
// - Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// - sk == endWord

// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
// sequence from beginWord to endWord, or 0 if no such sequence exists.

public class WordLadder {

	// BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dictionary = new HashSet<>(wordList);
		if (!dictionary.contains(endWord)) {
			return 0;
		}

		int length = 1;
		Set<String> visited = new HashSet<>();

		Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// optimization: flip beginSet and endSet to save time
			if (beginSet.size() > endSet.size()) {
				flip(beginSet, endSet);
			}
			// try out all 26 possible characters for each char of each string in beginSet
			Set<String> next = new HashSet<>(); // next level of BFS
			for (String s : beginSet) {
				char[] chars = s.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char originalChar = chars[i];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						chars[i] = ch; // modify
						String nextWord = String.valueOf(chars);
						if (endSet.contains(nextWord)) {
							return length + 1;
						}
						if (!visited.contains(nextWord) && dictionary.contains(nextWord)) {
							visited.add(nextWord);
							next.add(nextWord);
						}
						chars[i] = originalChar; // modify back
					}
				}
			}
			beginSet = next;
			length++;
		}
		return 0;
	}

	private void flip(Set<String> beginSet, Set<String> endSet) {
		Set<String> temp = beginSet;
		beginSet = endSet;
		endSet = temp;
	}

	// Follow up: Return all shortest transformation sequences.
	// LeetCode #126 (Word Ladder II).
}