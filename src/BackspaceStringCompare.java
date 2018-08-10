import java.util.Stack;

// LeetCode #844 (Backspace String Compare).

// Given two strings S and T, return if they are equal when both are typed into 
// empty text editors. # means a backspace character.

public class BackspaceStringCompare {

	// Solution 1: Stack
	public boolean backspaceCompare(String S, String T) {
		return build(S).equals(build(T));
	}

	private String build(String str) {
		Stack<Character> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c != '#') {
				stack.push(c);
			} else if (!stack.empty()) {
				stack.pop();
			}
		}
		return String.valueOf(stack);
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m + n).

	// Solution 2: Two pointers
	public boolean backspaceCompare2(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else {
					break;
				}
			}
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else {
					break;
				}
			}
			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
				return false;
			}
			if ((i >= 0) != (j >= 0)) {
				return false;
			}
			i--;
			j--;
		}
		return (i == j);
	}

	// Time complexity is O(min(m, n)).
	// Space complexity is O(1).
}
