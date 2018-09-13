import java.util.HashSet;
import java.util.Set;

// LeetCode #139 (Word Break).

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
// determine if s can be segmented into a space-separated sequence of one or more dictionary
// words.

// Notes:
// 1. The same word in the dictionary may be reused multiple times in the segmentation.
// 2. You may assume the dictionary does not contain duplicate words.

public class WordBreak {

	// M[i]: Whether [0, i - 1] of input can be composed by concatenating words from
	// the dictionary.
	public boolean canBreak(String input, String[] dict) {
		Set<String> set = new HashSet<>();
		for (String s : dict) {
			set.add(s);
		}
		boolean[] array = new boolean[input.length() + 1];
		array[0] = true;
		for (int i = 1; i <= input.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] && set.contains(input.substring(j, i))) {
					array[i] = true;
					break;
				}
			}
		}
		return array[input.length()];
	}

	// Let m be the length of String s, and n be the size of the dictionary.
	// Time complexity is O(n + m^3).
	// Space complexity is O(n + m).

	// Follow up: Return all possible compositions?
	// LeetCode #140 (Word Break II).
}
