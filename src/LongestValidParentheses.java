import java.util.LinkedList;

// LeetCode #32 (Longest Valid Parentheses).

// Given a string containing just the characters '(' and ')', find the length of the 
// longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()",
// which has length = 4.

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.offerLast(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || (stack.size() == 1 || s.charAt(stack.peekLast()) != '(')) {
				stack.offerLast(i);
			} else {
				stack.pollLast();
			}
		}
		stack.offerLast(s.length());
		int max = 0;
		while (stack.size() > 1) {
			max = Math.max(max, stack.pollLast() - stack.peekLast() - 1);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
