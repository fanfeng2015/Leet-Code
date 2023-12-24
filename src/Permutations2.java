import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// LeetCode #47 (Permutations II).

// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

public class Permutations2 {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, result);
		return result;
	}

	private void dfs(int[] nums, int level, List<List<Integer>> result) {
		if (level == nums.length) {
			result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = level; i < nums.length; i++) {
			if (set.add(nums[i])) {
				swap(nums, i, level);
				dfs(nums, level + 1, result);
				swap(nums, i, level);
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// Time complexity is O(n + n*(n-1) + n*(n-1)*(n-2) + ... + n!) = O(n!)
	// Space complexity is O(n) because of call-stack.
}
