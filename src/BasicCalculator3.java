// LeetCode #772 (Basic Calculator III).

// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
// The integer division should truncate toward zero.

// You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].

import java.util.Stack;

public class BasicCalculator3 {

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

}
