import java.util.ArrayList;
import java.util.List;

// LeetCode #39 (Combination Sum).

// Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
// find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS(candidates, target, cur, result, 0);
		return result;
	}

	private void DFS(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result, int start) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			cur.add(candidates[i]);
			DFS(candidates, target - candidates[i], cur, result, i); // i + 1 if no repetition
			cur.remove(cur.size() - 1);
		}
	}

	// Time complexity is O(n^target).
	// Space complexity is O(target).

	// LaiCode: Combinations of Coins
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		DFS2(candidates, target, cur, result, 0);
		return result;
	}

	private void DFS2(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result, int level) {
		if (level == candidates.length) {
			if (target == 0) {
				add(candidates, cur, result);
			}
			return;
		}
		for (int i = 0; i <= target / candidates[level]; i++) {
			cur.add(i);
			DFS2(candidates, target - i * candidates[level], cur, result, level + 1);
			cur.remove(cur.size() - 1);
		}
	}

	private void add(int[] candidates, List<Integer> cur, List<List<Integer>> result) {
		List<Integer> r = new ArrayList<>();
		for (int i = 0; i < cur.size(); i++) { // add candidates[i] cur.get(i) many times
			for (int j = 0; j < cur.get(i); j++) {
				r.add(candidates[i]);
			}
		}
		result.add(r);
	}

	// Time complexity is O(target^n), ignoring time that add(...) takes.
	// Space complexity is O(n).
}
