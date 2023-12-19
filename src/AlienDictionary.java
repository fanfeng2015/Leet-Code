import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// LeetCode #269 (Alien Dictionary).

// There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

// You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are 
// sorted lexicographically by the rules of this new language.

// If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

// Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the
// new language's rules. If there are multiple solutions, return any of them.

public class AlienDictionary {

	private static final int NUM_LETTERS = 26;

	public String alienOrder(String[] words) {
		int[] incomingDegrees = new int[NUM_LETTERS];
		Arrays.fill(incomingDegrees, -1); // -1 indicates not exist
		List<Set<Character>> adjacencyList = new ArrayList<>();
		int count = constructGraph(words, incomingDegrees, adjacencyList);
		return topologicalSort(incomingDegrees, adjacencyList, count);
	}

	// returns the number of unique characters (need to check if graph is DAG)
	private int constructGraph(String[] words, int[] incomingDegrees, List<Set<Character>> adjacencyList) {
		int count = 0;
		for (int i = 0; i < NUM_LETTERS; i++) {
			adjacencyList.add(new HashSet<Character>());
		}
		for (int i = 0; i < words.length; i++) {
			String cur = words[i];
			// check for the first appearance
			for (char ch : cur.toCharArray()) {
				if (incomingDegrees[ch - 'a'] == -1) {
					count++;
					incomingDegrees[ch - 'a'] = 0;
				}
			}
			if (i > 0) {
				String prev = words[i - 1];
				int index = 0;
				while (index < prev.length() && index < cur.length() && prev.charAt(index) == cur.charAt(index)) {
					index++;
				}
				if (index < prev.length() && index < cur.length()
						&& adjacencyList.get(prev.charAt(index) - 'a').add(cur.charAt(index))) {
					incomingDegrees[cur.charAt(index) - 'a']++;
				}
			}
		}
		return count;
	}

	private String topologicalSort(int[] incomingDegrees, List<Set<Character>> adjacencyList, int count) {
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> queue = new LinkedList<>();
		for (int i = 0; i < NUM_LETTERS; i++) {
			if (incomingDegrees[i] == 0) {
				queue.offerFirst((char) ('a' + i));
			}
		}
		while (!queue.isEmpty()) {
			char ch = queue.pollLast();
			sb.append(ch);
			for (char neighbor : adjacencyList.get(ch - 'a')) {
				incomingDegrees[neighbor - 'a']--;
				if (incomingDegrees[neighbor - 'a'] == 0) {
					queue.offerFirst(neighbor);
				}
			}
		}
		return sb.length() == count ? sb.toString() : "";
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
