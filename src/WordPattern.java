import java.util.HashMap;
import java.util.Map;

// LeetCode #290 (Word Pattern).

// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a 
// non-empty word in str.

public class WordPattern {

	// Same as LeetCode #205 (Isomorphic Strings).
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}
		Map<Character, String> patternToStr = new HashMap<>();
		Map<String, Character> strToPattern = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			String s = patternToStr.get(pattern.charAt(i));
			Character ch = strToPattern.get(words[i]);
			if (s == null && ch == null) {
				patternToStr.put(pattern.charAt(i), words[i]);
				strToPattern.put(words[i], pattern.charAt(i));
			} else if (s == null || ch == null || !s.equals(words[i]) || !ch.equals(pattern.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}