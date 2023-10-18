// LeetCode #53 (Maximum Subarray).

// Given an integer array nums, find the subarray with the largest sum, and return its sum.

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int cur = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = Math.max(nums[i], cur + nums[i]);
			max = Math.max(max, cur);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
