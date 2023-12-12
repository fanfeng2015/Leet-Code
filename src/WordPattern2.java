import java.util.HashMap;
import java.util.Map;

// LeetCode #291 (Word Pattern II).

// Given a pattern and a string s, return true if s matches the pattern.

// A string s matches a pattern if there is some bijective mapping of single characters to non-empty strings such that if each 
// character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no
// two characters map to the same string, and no character maps to two different strings.

public class WordPattern2 {

	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> charToStr = new HashMap<>();
		Map<String, Character> strToChar = new HashMap<>();
		return DFS(pattern, str, charToStr, strToChar, 0, 0);
	}

	// m indicates index of "pattern", n indicates the starting index of "str".
	private boolean DFS(String pattern, String str, Map<Character, String> charToStr, Map<String, Character> strToChar,
			int m, int n) {
		if (m == pattern.length() || n == str.length()) {
			return (m == pattern.length()) && (n == str.length());
		}
		for (int i = n; i < str.length(); i++) {
			String substr = str.substring(n, i + 1);
			String s = charToStr.get(pattern.charAt(m));
			Character c = strToChar.get(substr);
			if (s == null && c == null) {
				charToStr.put(pattern.charAt(m), substr);
				strToChar.put(substr, pattern.charAt(m));
				if (DFS(pattern, str, charToStr, strToChar, m + 1, i + 1)) {
					return true;
				}
				charToStr.remove(pattern.charAt(m));
				strToChar.remove(substr);
			} else if (s != null && c != null && s.equals(substr) && c.equals(pattern.charAt(m))) {
				return DFS(pattern, str, charToStr, strToChar, m + 1, i + 1);
			}
		}
		return false;
	}

	// Time complexity is O(n^n).
	// Space complexity is O(n).
}
