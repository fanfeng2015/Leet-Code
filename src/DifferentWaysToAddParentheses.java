import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #241 (Different Ways to Add Parentheses).

// Given a string of numbers and operators, return all possible results from 
// computing all the different possible ways to group numbers and operators.

// The valid operators are +, - and *.

public class DifferentWaysToAddParentheses {

	// Divide and Conquer
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> leftValues = diffWaysToCompute(left);
				List<Integer> rightValues = diffWaysToCompute(right);
				for (Integer leftValue : leftValues) {
					for (Integer rightValue : rightValues) {
						int cur = 0;
						if (input.charAt(i) == '+') {
							cur = leftValue + rightValue;
						} else if (input.charAt(i) == '-') {
							cur = leftValue - rightValue;
						} else if (input.charAt(i) == '*') {
							cur = leftValue * rightValue;
						}
						result.add(cur);
					}
				}
			}
		}
		if (result.size() == 0) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).

	// Optimization: Memoization
	public List<Integer> diffWaysToCompute2(String input) {
		List<Integer> result = new ArrayList<Integer>();
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				List<Integer> leftValues = null, rightValues = null;
				leftValues = map.containsKey(left) ? map.get(left) : diffWaysToCompute(left);
				map.put(left, leftValues);
				rightValues = map.containsKey(right) ? map.get(right) : diffWaysToCompute(right);
				map.put(right, rightValues);
				for (Integer leftValue : leftValues) {
					for (Integer rightValue : rightValues) {
						int cur = 0;
						if (input.charAt(i) == '+') {
							cur = leftValue + rightValue;
						} else if (input.charAt(i) == '-') {
							cur = leftValue - rightValue;
						} else if (input.charAt(i) == '*') {
							cur = leftValue * rightValue;
						}
						result.add(cur);
					}
				}
			}
		}
		if (result.size() == 0) {
			result.add(Integer.valueOf(input));
		}
		return result;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).
}
