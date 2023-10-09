import java.util.ArrayList;
import java.util.List;

// LeetCode #78 (Subsets).

// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, cur, result, 0);
		return result;
	}

	private void dfs(int[] nums, List<Integer> cur, List<List<Integer>> result, int index) {
		if (index == nums.length) {
			result.add(new ArrayList<>(cur));
			return;
		}
		cur.add(nums[index]);
		dfs(nums, cur, result, index + 1);
		cur.remove(cur.size() - 1);
		dfs(nums, cur, result, index + 1);
	}

	// Time complexity is O(2^n).
	// Space complexity is O(n), because of call-stack. 
}
