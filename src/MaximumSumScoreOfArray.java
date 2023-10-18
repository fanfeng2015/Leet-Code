// LeetCode #2219 (Maximum Sum Score of Array).

// You are given a 0-indexed integer array nums of length n.

// The sum score of nums at an index i where 0 <= i < n is the maximum of:
// 1. The sum of the first i + 1 elements of nums.
// 2. The sum of the last n - i elements of nums.

// Return the maximum sum score of nums at any index.

public class MaximumSumScoreOfArray {

	public long maximumSumScore(int[] nums) {
		long suffixSum = 0, prefixSum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			suffixSum += nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			suffixSum -= (i == 0) ? 0 : nums[i - 1];
			max = Math.max(max, Math.max(prefixSum, suffixSum));
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
