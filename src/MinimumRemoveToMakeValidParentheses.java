// LeetCode #1249 (Minimum Remove to Make Valid Parentheses).

// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:
// - It is the empty string, contains only lowercase characters, or
// - It can be written as AB (A concatenated with B), where A and B are valid strings, or
// - It can be written as (A), where A is a valid string.

public class MinimumRemoveToMakeValidParentheses {

	public String minRemoveToMakeValid(String s) {
		int count = 0; // # of left parentheses
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' || count > 0) {
				temp.append(s.charAt(i));
			}
			// update count
			if (s.charAt(i) == '(') {
				count = count + 1;
			} else if (s.charAt(i) == ')') {
				count = Math.max(0, count - 1);
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = temp.length() - 1; i >= 0; i--) {
			if (temp.charAt(i) == '(' && count-- > 0) {
				continue;
			}
			result.append(temp.charAt(i));
		}
		return result.reverse().toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
