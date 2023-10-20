// LeetCode #303 (Range Sum Query - Immutable).

// Given an integer array nums, handle multiple queries of the following type:

// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

public class RangeSumQueryImmutable {

	int[] nums;

	public RangeSumQueryImmutable(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		return nums[j] - (i == 0 ? 0 : nums[i - 1]);
	}

	// Time complexity is O(n) to construct and O(1) to query.
	// Space complexity is O(1).
}