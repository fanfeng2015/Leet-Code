// LeetCode #689 (Maximum Sum of 3 Non-Overlapping Subarrays).

// In a given array nums of positive integers, find three non-overlapping subarrays 
// with maximum sum.

// Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

// Return the result as a list of indices representing the starting position of each 
// interval (0-indexed). If there are multiple answers, return the lexicographically 
// smallest one.

// Notes:
// 1. nums.length will be between 1 and 20000.
// 2. nums[i] will be between 1 and 65535.
// 3. k will be between 1 and floor(nums.length / 3).

public class MaximumSumOf3NonOverlappingSubarrays {

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length;
		int[] sum = new int[n + 1]; // sum[i]: sum of nums in [0, i - 1]
		int[] left = new int[n]; // left[i]: begin index of the maximum size k subarray in [0, i]
		int[] right = new int[n]; // right[i]: begin index of the maximum size k subarray in [i, n - 1]
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
		int max = sum[k] - sum[0];
		for (int begin = 1; begin <= n - k; begin++) {
			if (sum[begin + k] - sum[begin] > max) {
				left[begin + k - 1] = begin;
				max = sum[begin + k] - sum[begin];
			} else {
				left[begin + k - 1] = left[begin + k - 2];
			}
		}
		max = sum[n] - sum[n - k];
		right[n - k] = n - k;
		for (int begin = n - k - 1; begin >= 0; begin--) {
			if (sum[begin + k] - sum[begin] >= max) {
				right[begin] = begin;
				max = sum[begin + k] - sum[begin];
			} else {
				right[begin] = right[begin + 1];
			}
		}
		int prev = 0;
		int[] result = new int[3];
		for (int i = k; i <= n - 2 * k; i++) {
			int l = left[i - 1], r = right[i + k];
			int cur = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
			if (cur > prev) {
				prev = cur;
				result[0] = l;
				result[1] = i;
				result[2] = r;
			}
		}
		return result;
	}

	// Time complexity is O(n - k).
	// Space complexity is O(n).
}
