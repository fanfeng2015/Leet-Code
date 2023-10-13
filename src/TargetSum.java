// LeetCode #494 (Target Sum).

// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each
// integer in nums and then concatenate all the integers.

public class TargetSum {

	private int count = 0;

	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, target, 0);
		return count;
	}

	private void dfs(int[] nums, int target, int index) {
		if (index == nums.length) {
			if (target == 0) {
				count++;
			}
			return;
		}
		dfs(nums, target - nums[index], index + 1); // pick a '+'
		dfs(nums, target + nums[index], index + 1); // pick a '-'
	}

	// Time complexity is O(2*n).
	// Space complexity is O(n).

	// Duplicate computation exists for the same (index, target) pair.

	// E.g., nums = [1, 1, 1, 1, 1], target = 5

	// Picking [1, -1] and [-1, 1] for the first two numbers result in the same
	// recursive computation.

	// dp[i][j]: number of ways for numbers indexed between [0, i] to sum up to j.
	// dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]

	// [ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0]
	// [ 0, 0, 0, 1, 0, 2, 0, 1, 0, 0, 0]
	// [ 0, 0, 1, 0, 3, 0, 3, 0, 1, 0, 0]
	// [ 0, 1, 0, 4, 0, 6, 0, 4, 0, 1, 0]
	// [ 1, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0]

	public int findTargetSumWays2(int[] nums, int target) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += Math.abs(nums[i]);
		}
		int[] prev = new int[2 * sum + 1], next = new int[2 * sum + 1];
		prev[sum] = 1; // zero numbers can still sum up to 0, offset index by sum
		for (int i = 0; i < nums.length; i++) {
			for (int j = -sum; j <= sum; j++) {
				int plus = (j - nums[i] < -sum) ? 0 : prev[j - nums[i] + sum]; // offset index by sum
				int minus = (j + nums[i] > sum) ? 0 : prev[j + nums[i] + sum]; // offset index by sum
				next[j + sum] = plus + minus; // offset index by sum
			}
			prev = next;
			next = new int[2 * sum + 1];
		}
		return (target < -sum || target > sum) ? 0 : prev[target + sum]; // offset index by sum
	}

	// Time complexity is O(n*t).
	// Space complexity is O(t).
}
