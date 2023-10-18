// LeetCode #713 (Subarray Product Less Than K).

// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the 
// product of all the elements in the subarray is strictly less than k.

public class SubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int left = 0, right = 0, product = 1, count = 0;
		for (; right < nums.length; right++) {
			product *= nums[right];
			while (product >= k) {
				product /= nums[left++];
			}
			count += (right - left + 1);
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
