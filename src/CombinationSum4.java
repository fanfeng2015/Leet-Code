// LeetCode #377 (Combination Sum IV).

// Given an integer array with all positive numbers and no duplicates, find the number 
// of possible combinations that add up to a positive integer target.

public class CombinationSum4 {

	public int combinationSum4(int[] nums, int target) {
		// M[i]: number of combinations adding up to i
		int[] M = new int[target + 1];
		M[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int n : nums) {
				M[i] += (i - n >= 0) ? M[i - n] : 0;
			}
		}
		return M[target];
	}

	// Time complexity is O(n*target).
	// Space complexity is O(target).
}
