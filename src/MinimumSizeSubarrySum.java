// LeetCode #209 (Minimum Size Subarray Sum).

// Given an array of n positive integers and a positive integer s, find the minimal
// length of a contiguous subarray of which the sum >= s. If there isn't one, return
// 0 instead.

public class MinimumSizeSubarrySum {

	// Solution 1
	public int minSubArrayLen(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int i = 0, j = 0, sum = 0; // cummulative sum of nums in [i, j]
		for (; j < nums.length; j++) {
			sum += nums[j];
			while (sum >= s) {
				min = Math.min(min, j - i + 1);
				sum -= nums[i++];
			}
		}
		return (min == Integer.MAX_VALUE) ? 0 : min;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Solution 2: O(n*log(n)) time, O(n) space.
	
	// 1. Compute the array of prefix sums.
	// 2. For each prefix sum, run binary search to get the index of the smallest
	//    prefix sum >= (prefix sum + s). Update min if index < n.
}
