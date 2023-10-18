// LeetCode #643 (Maximum Average Subarray I).

// You are given an integer array nums consisting of n elements, and an integer k.

// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this
// value. Any answer with a calculation error less than 10-5 will be accepted.

public class MaximumAverageSubarrayI {

	public double findMaxAverage(int[] nums, int k) {
		double max = -Double.MAX_VALUE;
		int left = 0, right = 0, sum = 0;
		for (; right < k; right++) {
			sum += nums[right];
		}
		max = Math.max(max, (double) sum / k);
		while (right < nums.length) {
			sum -= nums[left++];
			sum += nums[right++];
			max = Math.max(max, (double) sum / k);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
