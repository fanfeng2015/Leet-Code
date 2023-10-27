import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode #39 (Combination Sum).

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
// where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least
// one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the
// given input.

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
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

	// DP
	// M[i]: List of all combinations that sum to i.
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<List<Integer>>> result = new ArrayList<>();
		for (int i = 0; i <= target; i++) {
			List<List<Integer>> cur = new ArrayList<>();
			for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
				if (candidates[j] == i) {
					cur.add(Arrays.asList(candidates[j]));
				} else {
					List<List<Integer>> prev = result.get(i - candidates[j]);
					for (List<Integer> combo : prev) {
						if (candidates[j] <= combo.get(0)) {
							List<Integer> temp = new ArrayList<>();
							temp.add(candidates[j]);
							temp.addAll(combo);
							cur.add(temp);
						}
					}
				}
			}
			result.add(cur);
		}
		return result.get(target);
	}

	// Time complexity is O(target * n * combo).
	// Space complexity is O(target * combo).
}
