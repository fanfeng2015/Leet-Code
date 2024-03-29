import java.util.ArrayList;
import java.util.List;

// LeetCode 282 (Expression Add Operators).

// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+',
// '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

// Note that operands in the returned expressions should not contain leading zeros.

public class ExpressionAddOperators {

	public List<String> addOperators(String num, int target) {
		StringBuilder sb = new StringBuilder();
		List<String> result = new ArrayList<>();
		DFS(num, target, sb, result, 0, 0, 0);
		return result;
	}

	private void DFS(String num, int target, StringBuilder sb, List<String> result, int pos, long soFar, long mult) {
		if (pos == num.length()) {
			if (soFar == target) {
				result.add(sb.toString());
			}
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (num.charAt(pos) == '0' && i != pos) {
				break;
			}
			long cur = Long.parseLong(num.substring(pos, i + 1));
			int length = sb.length();
			if (pos == 0) {
				DFS(num, target, sb.append(cur), result, i + 1, cur, cur);
				sb.setLength(length);
			} else {
				DFS(num, target, sb.append('+').append(cur), result, i + 1, soFar + cur, cur);
				sb.setLength(length);
				DFS(num, target, sb.append('-').append(cur), result, i + 1, soFar - cur, -cur);
				sb.setLength(length);
				DFS(num, target, sb.append('*').append(cur), result, i + 1, soFar + mult * (cur - 1), mult * cur);
				sb.setLength(length);
			}
		}
	}

	// Time complexity is O(3^n).
	// Space complexity is O(n).
}
