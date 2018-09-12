import java.util.ArrayList;
import java.util.List;

// LeetCode #386 (Lexicographical Numbers).

// Given an integer n, return 1 - n in lexicographical order.

// For example, given 13, return: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9].

// The input size may be as large as 5,000,000.

public class LexicographicalNumbers {

	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			DFS(n, i, result);
		}
		return result;
	}

	private void DFS(int n, int cur, List<Integer> result) {
		if (cur > n) {
			return;
		}
		result.add(cur);
		for (int i = 0; i <= 9; i++) {
			if (cur * 10 + i <= n) {
				DFS(n, cur * 10 + i, result);
			}
		}
	}

	// Time complexity is O(n).
	// Space complexity is O(log(n)).
}
