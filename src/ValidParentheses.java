import java.util.LinkedList;

//LeetCode #20 (Valid Parentheses).

// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
// if the input string is valid.

// An input string is valid if:
//   -- Open brackets must be closed by the same type of brackets.
//   -- Open brackets must be closed in the correct order.
//   -- Every close bracket has a corresponding open bracket of the same type.

public class ValidParentheses {

	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.offerFirst(s.charAt(i));
			} else if (s.charAt(i) == ')' && stack.size() > 0 && stack.peekFirst() == '(') {
				stack.pollFirst();
			} else if (s.charAt(i) == ']' && stack.size() > 0 && stack.peekFirst() == '[') {
				stack.pollFirst();
			} else if (s.charAt(i) == '}' && stack.size() > 0 && stack.peekFirst() == '{') {
				stack.pollFirst();
			} else {
				return false;
			}
		}
		return stack.size() == 0;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).	
	
}
