import java.util.HashMap;
import java.util.Map;

// LeetCode #290 (Word Pattern).

// Given a pattern and a string str, find if str follows the same pattern.

// Here follow means a full match, such that there is a bijection between a letter in pattern and a 
// non-empty word in str.

// Note: You may assume pattern contains only lowercase letters, and str contains lowercase letters'
// separated by a single space.

public class WordPattern {

	// Same as LeetCode #205 (Isomorphic Strings).
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}
		Map<Character, String> charToStr = new HashMap<>();
		Map<String, Character> strToChar = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			String s = charToStr.get(pattern.charAt(i));
			Character c = strToChar.get(words[i]);
			if (s == null && c == null) {
				charToStr.put(pattern.charAt(i), words[i]);
				strToChar.put(words[i], pattern.charAt(i));
			} else if (s == null || c == null || !s.equals(words[i]) || !c.equals(pattern.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(n*k).
}