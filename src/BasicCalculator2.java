import java.util.Stack;

// LeetCode #227 (Basic Calculator II).

// Given a string s which represents an expression, evaluate this expression and return its value. 

// The integer division should truncate toward zero.

// You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].

public class BasicCalculator2 {

	public int calculate(String s) {
		int num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = 10 * num + Character.getNumericValue(s.charAt(i));
			}
			if ((!Character.isDigit(s.charAt(i)) && (s.charAt(i) != ' ')) || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') { // evaluate
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				num = 0;
				sign = s.charAt(i);
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
