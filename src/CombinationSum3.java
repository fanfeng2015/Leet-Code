import java.util.ArrayList;
import java.util.List;

// LeetCode #216 (Combination Sum III).

// Find all possible combinations of k numbers that add up to a number n, given that only numbers
// from 1 to 9 can be used and each combination should be a unique set of numbers.

// Assumptions:
// 1. All numbers will be positive integers.
// 2. The solution set must not contain duplicate combinations.

public class CombinationSum3 {

	private static final int MAX = 9;

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
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
			DFS(k, n - i, cur, result, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(k^n).
	// Space complexity is O(n).
}
