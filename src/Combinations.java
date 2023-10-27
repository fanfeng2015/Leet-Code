import java.util.ArrayList;
import java.util.List;

// LeetCode #77 (Combinations).

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

// You may return the answer in any order.

public class Combinations {

	// ------------------------------ 2018 ------------------------------
	public List<List<Integer>> combine(int n, int k) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		DFS(n, k, cur, result);
		return result;
	}

	private void DFS(int n, int k, List<Integer> cur, List<List<Integer>> result) {
		if (cur.size() == k) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = (cur.size() == 0) ? 1 : (cur.get(cur.size() - 1) + 1); i <= n; i++) {
			if (cur.size() == k) { // optimization
				break;
			}
			cur.add(i);
			DFS(n, k, cur, result);
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(n^k).
	// Space complexity is O(k).

	// ------------------------------ 2023 ------------------------------
	public List<List<Integer>> combine2(int n, int k) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		dfs(n, k, 1, cur, result);
		return result;
	}

	private void dfs(int n, int k, int num, List<Integer> cur, List<List<Integer>> result) {
		if (k == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		if (num > n) {
			return;
		}
		cur.add(num);
		dfs(n, k - 1, num + 1, cur, result);
		cur.remove(cur.size() - 1);
		dfs(n, k, num + 1, cur, result);
	}

	// Time complexity is O(n^k).
	// Space complexity is O(k).
}
