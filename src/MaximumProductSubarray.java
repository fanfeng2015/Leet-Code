// LeetCode #152 (Maximum Product Subarray).

// Given an integer array nums, find a subarray that has the largest product, and return the
// product. The test cases are generated so that the answer will fit in a 32-bit integer.

public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		int result = Integer.MIN_VALUE;
		int max_so_far = 1, min_so_far = 1;
		for (int i = 0; i < nums.length; i++) {
			int temp = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
			min_so_far = Math.min(nums[i], Math.min(max_so_far * nums[i], min_so_far * nums[i]));
			max_so_far = temp;
			result = Math.max(result, max_so_far);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
