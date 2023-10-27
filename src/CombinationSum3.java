import java.util.ArrayList;
import java.util.List;

// LeetCode #216 (Combination Sum III).

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

// - Only numbers 1 through 9 are used.
// - Each number is used at most once.

// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be
// returned in any order.

public class CombinationSum3 {

	private static final int MAX = 9;

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		DFS(k, n, cur, result, 1);
		return result;
	}

	private void DFS(int k, int n, List<Integer> cur, List<List<Integer>> result, int start) {
		if (n < 0) { // optimization
			return;
		} else if (n == 0 && cur.size() == k) {
			result.add(new ArrayList<Integer>(cur));
		}
		for (int i = start; i <= MAX; i++) {
			if (cur.size() >= k) { // optimization
				break;
			}
			cur.add(i);
			DFS(k, n - i, cur, result, i + 1); // each number from 1 to 9 is allowed at most once
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(k^n).
	// Space complexity is O(n).
}
