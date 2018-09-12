// LeetCode #316 (Remove Duplicate Letters).

// Given a string which contains only lower-case letters, remove duplicate letters
// so that every letter appears once and only once. 

// You must make sure your result is the smallest in lexicographical order among all
// possible results.

public class RemoveDuplicateLetters {

	private static final int NUM_LETTERS = 26;

	public String removeDuplicateLetters(String s) {
		int[] countMap = countFrequency(s);
		boolean[] visited = new boolean[NUM_LETTERS];
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			countMap[ch - 'a']--;
			if (!visited[ch - 'a']) {
				// keep removing the last char as long the it is greater than the current char
				// and is not the last occurrence
				while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch
						&& countMap[sb.charAt(sb.length() - 1) - 'a'] > 0) {
					visited[sb.charAt(sb.length() - 1) - 'a'] = false;
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append(ch);
				visited[ch - 'a'] = true;
			}
		}
		return sb.toString();
	}

	private int[] countFrequency(String s) {
		int[] countMap = new int[NUM_LETTERS];
		for (char ch : s.toCharArray()) {
			countMap[ch - 'a']++;
		}
		return countMap;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
