import java.util.ArrayList;
import java.util.List;

// LeetCode #22 (Generate Parentheses).

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) { // n > 0
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(n, sb, 0, 0, result);
		return result;
	}

	private void dfs(int n, StringBuilder sb, int left, int right, List<String> result) {
		if (sb.length() == 2 * n) {
			result.add(sb.toString());
			return;
		}
		if (left < n) {
			sb.append("(");
			dfs(n, sb, left + 1, right, result);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			dfs(n, sb, left, right + 1, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// Time complexity is O(2^(2*n)), although this is an upper bound because some
	// branches are cut off.
	// Space complexity is O(n).
}
