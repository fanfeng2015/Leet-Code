import java.util.ArrayList;
import java.util.List;

// LeetCode #254 (Factor Combinations).

// Write a function that takes an integer n and return all possible combinations of its factors.

// Notes:
// 1. You may assume that n is always positive.
// 2. Factors should be greater than 1 and less than n.

public class FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
		if (n == 1) {
			return new ArrayList<>();
		}
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i * i <= n; i++) {
			if (i * i == n) {
				factors.add(i);
			} else if (n % i == 0) {
				factors.add(i);
				factors.add(n / i);
			}
		}
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		DFS(factors, cur, result, 0, n);
		return result;
	}

	private void DFS(List<Integer> factors, List<Integer> cur, List<List<Integer>> result, int level, int target) {
		if (level == factors.size()) {
			if (target == 1) {
				result.add(convert(factors, cur));
			}
			return;
		}
		for (int i = 0; i <= Math.log(target) / Math.log(factors.get(level)); i++) {
			if (target % Math.pow(factors.get(level), i) == 0) {
				cur.add(i);
				DFS(factors, cur, result, level + 1, target / (int) Math.pow(factors.get(level), i));
				cur.remove(cur.size() - 1);
			}
		}
	}

	private List<Integer> convert(List<Integer> factors, List<Integer> cur) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < cur.size(); i++) {
			for (int j = 0; j < cur.get(i); j++) {
				result.add(factors.get(i));
			}
		}
		return result;
	}

}
