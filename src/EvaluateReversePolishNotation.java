import java.util.LinkedList;

// LeetCode #150 (Evaluate Reverse Polish Notation).

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Examples: 
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<>();
		int a = 0, b = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				b = stack.pollLast();
				a = stack.pollLast();
				stack.offerLast(a + b);
			} else if (tokens[i].equals("-")) {
				b = stack.pollLast();
				a = stack.pollLast();
				stack.offerLast(a - b);
			} else if (tokens[i].equals("*")) {
				b = stack.pollLast();
				a = stack.pollLast();
				stack.offerLast(a * b);
			} else if (tokens[i].equals("/")) {
				b = stack.pollLast();
				a = stack.pollLast();
				stack.offerLast(a / b);
			} else {
				stack.offerLast(Integer.parseInt(tokens[i]));
			}
		}
		return stack.peekLast();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
