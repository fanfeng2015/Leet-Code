import java.util.LinkedList;

// LeetCode #224 (Basic Calculator).

// Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the 
// evaluation.

public class BasicCalculator {

	public int calculate(String s) {
		int result = 0;
		int sign = 1, num = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = 10 * num + Character.getNumericValue(s.charAt(i));
			} else if (s.charAt(i) == '+') {
				result += sign * num;
				sign = 1;
				num = 0;
			} else if (s.charAt(i) == '-') {
				result += sign * num;
				sign = -1;
				num = 0;
			} else if (s.charAt(i) == '(') { // '(' must be preceded with '+' or '-', or is the first char
				stack.offerLast(result);
				stack.offerLast(sign);
				result = 0;
				sign = 1;
				// num = 0; guaranteed
			} else if (s.charAt(i) == ')') {
				result = (result + sign * num) * stack.pollLast() + stack.pollLast();
				sign = 1;
				num = 0;
			}
		}
		return result + sign * num;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
