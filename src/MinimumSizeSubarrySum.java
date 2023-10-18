// LeetCode #209 (Minimum Size Subarray Sum).

// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class MinimumSizeSubarrySum {

	// Solution 1
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
		for (; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				min = Math.min(min, right - left + 1);
				sum -= nums[left++];
			}
		}
		return (min == Integer.MAX_VALUE) ? 0 : min;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Solution 2: O(n*log(n)) time, O(n) space.

	// 1. Compute the array of prefix sums.
	// 2. For each prefix sum, run binary search to get the index of the smallest
	// prefix sum >= (prefix sum + s). Update min if index < n.
}
